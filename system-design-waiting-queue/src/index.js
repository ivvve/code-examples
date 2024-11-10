import { redisClient } from './redis.js';
import { MOVE_USERS_IN_WAITING_QUEUE_BATCH_INTERVAL_MILLIS, runMoveUsersInWaitingQueueBatchPeriodically, runRemoveOldEntryUsersBatchPeriodically } from './batch.js';

import Fastify from 'fastify'

const fastify = Fastify({ logger: false });

// 페이지 입장 시도
fastify.post('/try-enter', async (req, res) => {
  const { userId } = req.body;
  const result = await redisClient.tryToEnter(userId, Date.now());
  res.send(result);
});

// 페이지에 입장할 수 있는지 확인
fastify.post('/can-enter', async (req, res) => {
  const { userId } = req.body;
  const canEnterInfo = await redisClient.canEnter(userId);
  const [status, waitingIndex, refillTokenSize] = canEnterInfo;

  if (['ENTERED', 'NOT_WAITING'].includes(status)) {
    return res.send({
      status: status,
      waitingNo: null,
      expectedWaitingSeconds: null,
    })
  }

  // 예상 대기 시간 계산
  const expectedWaitingSeconds = Math.floor(waitingIndex/refillTokenSize + 1) * (MOVE_USERS_IN_WAITING_QUEUE_BATCH_INTERVAL_MILLIS / 1_000);

  res.send({
    status: status,
    waitingNo: waitingIndex + 1,
    expectedWaitingSeconds: expectedWaitingSeconds,
  });
});

// 대기열 이동 인원 수(토큰 수) 변경
fastify.post('/change-token-size', async (req, res) => {
  const { tokenSize } = req.body;
  await redisClient.changeRefillTokenSize(tokenSize);
  res.send({ "message": "ok" });
});

fastify.listen({ port: 3000 });

runMoveUsersInWaitingQueueBatchPeriodically();
runRemoveOldEntryUsersBatchPeriodically();

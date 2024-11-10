import {redisClient} from './redis.js';

const MOVE_USERS_IN_WAITING_QUEUE_BATCH_INTERVAL_MILLIS = 5 * 1_000;

// 대기열에 있는 유저를 입장 처리한다
function runMoveUsersInWaitingQueueBatchPeriodically() {
  return setInterval(async () => {
    console.time("Move users in waiting queue batch")

    await redisClient.moveUsersInWaitingQueueAndRefillToken(Date.now());

    console.timeEnd("Move users in waiting queue batch")
  }, MOVE_USERS_IN_WAITING_QUEUE_BATCH_INTERVAL_MILLIS);
}

// 입장한 지 오래된 유저들의 이력을 제거한다
function runRemoveOldEntryUsersBatchPeriodically() {
  return setInterval(async () => {
    console.time("Remove old entry users batch")

    await redisClient.removeOldEntryUsers(Date.now());

    console.timeEnd("Remove old entry users batch")
  }, 60 * 1_000);
}

export {
  runMoveUsersInWaitingQueueBatchPeriodically,
  runRemoveOldEntryUsersBatchPeriodically,
  MOVE_USERS_IN_WAITING_QUEUE_BATCH_INTERVAL_MILLIS,
}

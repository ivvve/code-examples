import Redis from 'ioredis';

const WAITING_QUEUE = "waiting-queue";
const ENTRY_QUEUE = "entry-queue";
const REFILL_TOKEN_SIZE = "refill-token-size"
const DEFAULT_REFILL_TOKEN_SIZE = 10;
const CURRENT_TOKEN = "current-token"

const redisClient = new Redis({
  host: '127.0.0.1',
  port: 6379,
  db: 0,
});

// 입장 시도 : 대기가 필요한 경우 대기열에 추가되고 대기가 필요하지 않으면 바로 입장시킨다
redisClient.defineCommand('tryToEnter', {
  numberOfKeys: 1,
  lua: `
        local userId = KEYS[1]
        local currentTimeMillis = tonumber(ARGV[1])

        -- 입장 시도 시 기존 대기열에 있던 사용자 제거
        redis.call('ZREM', '${WAITING_QUEUE}', userId)
        redis.call('ZREM', '${ENTRY_QUEUE}', userId)

        local currentTokens = tonumber(
            redis.call('GET', '${CURRENT_TOKEN}') or
            redis.call('GET', '${REFILL_TOKEN_SIZE}') or ${DEFAULT_REFILL_TOKEN_SIZE}
        )

        -- 토큰이 있으면 대기없이 바로 입장
        if 0 < currentTokens then
            redis.call('ZADD', '${ENTRY_QUEUE}', currentTimeMillis, userId)
            redis.call('SET', '${CURRENT_TOKEN}', currentTokens - 1) -- decr 사용 시 첫 요청 시 token이 -1로 저장됨
            return 'ENTERED'
        end

        -- 토큰이 없으면 대기 queue에 추가
        redis.call('ZADD', '${WAITING_QUEUE}', currentTimeMillis, userId)
        return 'WAITING'
    `
});

/**
 * 페이지에 입장할 수 있는지 확인
 *
 * return [유저 대기/입장 상태, 대기 시 대기 순서 index, 예상 대기 시간 계산을 위한 토큰 수]
 */
redisClient.defineCommand('canEnter', {
  numberOfKeys: 1,
  lua: `
        local userId = KEYS[1]
    
        local enteredAt = redis.call('ZSCORE', '${ENTRY_QUEUE}', userId)

        -- 입장한 경우
        if enteredAt ~= false then -- redis.call(ZSCORE)는 key나 value가 없는 경우 false를 리턴함
            return {'ENTERED', -1, -1}
        end

        local waitingIndex = redis.call('ZRANK', '${WAITING_QUEUE}', userId)
        
        -- 대기 중인 경우
        if waitingIndex ~= false then -- redis.call(ZRANK)는 key나 value가 없는 경우 false를 리턴함
            local refillTokenSize = tonumber(
                redis.call('GET', '${REFILL_TOKEN_SIZE}') or -- custom으로 설정한 리필 토큰 수
                ${DEFAULT_REFILL_TOKEN_SIZE} -- 기본 리필 토큰 수
            )

            return {'WAITING', waitingIndex, refillTokenSize}
        end

        -- 입장도 대기도 아닌 경우
        return {'NOT_WAITING', -1, -1}
    `
});

// 대기열에 있는 유저를 입장 처리하고 토큰을 채운다
redisClient.defineCommand('moveUsersInWaitingQueueAndRefillToken', {
  numberOfKeys: 0,
  lua: `
        local currentTimeMillis = ARGV[1]

        -- 리필 될 토큰의 양
        local numberOfRefilledTokens = tonumber(
            redis.call('GET', '${REFILL_TOKEN_SIZE}') or
            ${DEFAULT_REFILL_TOKEN_SIZE}
        )
        
        -- 대기열에 있는 유저 입장 처리: 토큰 소모
        local nextUserIds = redis.call('ZRANGE', '${WAITING_QUEUE}', 0, numberOfRefilledTokens - 1)

        for _i, userId in ipairs(nextUserIds) do
            redis.call('ZREM', '${WAITING_QUEUE}', userId)
            redis.call('ZADD', '${ENTRY_QUEUE}', currentTimeMillis, userId)
            numberOfRefilledTokens = numberOfRefilledTokens - 1
        end

        -- 추가된 유저를 제외 한 토큰 저장
        redis.call('SET', '${CURRENT_TOKEN}', numberOfRefilledTokens)
    `
});

redisClient.changeRefillTokenSize = (newRefillTokenSize) => {
  return redisClient.set(REFILL_TOKEN_SIZE, newRefillTokenSize);
}

redisClient.removeOldEntryUsers = (now) => {
  const thirtyMinutesAgo = now - 30 * 60 * 1_000;
  return redisClient.zremrangebyscore(ENTRY_QUEUE, '-inf', thirtyMinutesAgo);
}

export { redisClient };

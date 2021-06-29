const express = require('express');
const ioredis = require('ioredis');

const app = express();
const redisClient = new ioredis({
  host: 'node-redis',
  port: 6379
});

app.get('/', async (req, res) => {
  const i = await redisClient.incr('increment');
  res.send(`Current value - ${i}`);
});

app.listen(8080, () => {
  console.log('Node.js server is running...');
});

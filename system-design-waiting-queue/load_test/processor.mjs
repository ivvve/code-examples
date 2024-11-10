function randomUserId(requestParams, context, ee, next) {
  const id = Math.floor(Math.random() * 1_000_000_000);

  requestParams.json = {
    userId: `user-${id}`,
  };

  return next();
}

export { randomUserId };

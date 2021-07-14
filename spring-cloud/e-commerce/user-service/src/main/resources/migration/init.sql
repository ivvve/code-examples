CREATE TABLE users
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id            VARCHAR(255) UNIQUE,
    email              VARCHAR(255) UNIQUE,
    name               VARCHAR(255),
    encrypted_password VARCHAR(255)
);
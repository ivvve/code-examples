CREATE TABLE events
(
    id            BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    partition_key VARCHAR(200) NOT NULL,
    topic         VARCHAR(200) NOT NULL,
    payload       JSON         NOT NULL,
    created_at    DATETIME(2)  NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

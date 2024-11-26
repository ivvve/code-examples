CREATE TABLE events
(
    id            BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    status        VARCHAR(20)  NOT NULL,
    partition_key VARCHAR(200) NOT NULL,
    topic         VARCHAR(200) NOT NULL,
    payload       JSON         NOT NULL,
    created_at    DATETIME(2)  NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE INDEX idx_events_status_id ON events (status, id);

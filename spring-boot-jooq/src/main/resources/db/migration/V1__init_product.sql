CREATE TABLE products
(
    id             BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name           VARCHAR(255)   NOT NULL,
    unit_price     DECIMAL(12, 2) NOT NULL,
    stock_quantity INT UNSIGNED   NOT NULL,
    created_at     TIMESTAMP      NOT NULL,
    updated_at     TIMESTAMP      NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE orders
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id    VARCHAR(255),
    user_id     VARCHAR(255),
    product_id  VARCHAR(255),
    quantity    INT,
    unit_price  BIGINT,
    total_price BIGINT
);

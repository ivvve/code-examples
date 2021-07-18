CREATE TABLE catalogs
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_id VARCHAR(255),
    name VARCHAR(255),
    stock INT,
    unit_price BIGINT,
    created_at TIMESTAMP
);

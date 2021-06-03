CREATE TABLE shortened_urls (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    original VARCHAR(4096),
    code VARCHAR(7),
    created_at DATETIME
);

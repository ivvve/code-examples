package com.tistory.devs0n;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product registerProduct(final String name, final int stockQuantity) {
        final var product = new Product(name, stockQuantity);
        return this.productRepository.save(product);
    }

    public synchronized Product reduceProductStockQuantitySynchronized(final String productId, final int quantity) {
        return this.reduceProductStockQuantity(productId, quantity);
    }

    public Product reduceProductStockQuantity(final String productId, final int quantity) {
        final var product = this.productRepository.getById(productId);
        product.reduceQuantity(quantity);
        return this.productRepository.save(product);
    }
}

package com.tistory.devs0n;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private Map<String, Product> products = new HashMap<>();

    public Product save(final Product product) {
        final var productClone = product.clone();
        this.products.put(product.id, productClone);
        return product;
    }

    public Product getById(final String productId) {
        final var product = this.products.get(productId);

        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }

        return product.clone();
    }
}

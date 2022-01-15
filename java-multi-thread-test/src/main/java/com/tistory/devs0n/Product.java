package com.tistory.devs0n;

import java.util.UUID;

public class Product implements Cloneable {
    public String id;
    public String name;
    public int stockQuantity;

    public Product(final String name, final int stockQuantity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.stockQuantity = stockQuantity;
    }

    public void reduceQuantity(final int quantity) {
        if (stockQuantity - quantity < 0) {
            throw new IllegalArgumentException("Cannot reduce stock quantity less than 0");
        }

        this.stockQuantity -= quantity;
    }

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

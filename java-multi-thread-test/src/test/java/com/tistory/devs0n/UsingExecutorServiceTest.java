package com.tistory.devs0n;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

class UsingExecutorServiceTest {
    ProductRepository productRepository = new ProductRepository();
    ProductService productService = new ProductService(productRepository);

    @Test
    @DisplayName("ReduceProductStockQuantity")
    void ReduceProductStockQuantity() throws InterruptedException {
        // given
        final var stockQuantity = 1_000;
        final var product = productService.registerProduct("티셔츠", stockQuantity);

        final var service = Executors.newFixedThreadPool(50);
        final var latch = new CountDownLatch(stockQuantity);

        // when
        for (int i = 0; i < stockQuantity; i++) {
            service.execute(() -> {
//                productService.reduceProductStockQuantity(product.id, 1);
                productService.reduceProductStockQuantitySynchronized(product.id, 1);
                latch.countDown();
            });
        }
        latch.await();

        // then
        final var storedProduct = productRepository.getById(product.id);
        assertThat(storedProduct.stockQuantity).isEqualTo(0);
    }
}

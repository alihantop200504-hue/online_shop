package com.shop.online_shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KabylbaevAlikhanAsyncService {

    @Async
    public CompletableFuture<String> sendWelcomeNotification(String username) {
        log.info("Welcome notification sent to: {}", username);
        return CompletableFuture.completedFuture("Welcome " + username);
    }

    @Async
    public CompletableFuture<String> logOrderCreated(String username, Double totalPrice) {
        log.info("Order created by user: {} with total price: {}", username, totalPrice);
        return CompletableFuture.completedFuture("Order logged");
    }

    @Async
    public CompletableFuture<String> logImageUpload(String fileName, Long productId) {
        log.info("Image uploaded: {} for product id: {}", fileName, productId);
        return CompletableFuture.completedFuture("Image upload logged");
    }
}

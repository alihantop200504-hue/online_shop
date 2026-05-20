package com.shop.online_shop.controller;

import com.shop.online_shop.dto.request.KabylbaevAlikhanOrderRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanOrderResponse;
import com.shop.online_shop.enums.KabylbaevAlikhanOrderStatus;
import com.shop.online_shop.service.KabylbaevAlikhanOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class KabylbaevAlikhanOrderController {

    private final KabylbaevAlikhanOrderService orderService;

    @PostMapping
    public ResponseEntity<KabylbaevAlikhanOrderResponse> create(
            @Valid @RequestBody KabylbaevAlikhanOrderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<KabylbaevAlikhanOrderResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<KabylbaevAlikhanOrderResponse>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<KabylbaevAlikhanOrderResponse>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getByUserId(userId));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<KabylbaevAlikhanOrderResponse> updateStatus(
            @PathVariable Long id,
            @RequestParam KabylbaevAlikhanOrderStatus status) {
        return ResponseEntity.ok(orderService.updateStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

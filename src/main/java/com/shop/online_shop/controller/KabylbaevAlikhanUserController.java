package com.shop.online_shop.controller;

import com.shop.online_shop.dto.request.KabylbaevAlikhanRegisterRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanUserResponse;
import com.shop.online_shop.service.KabylbaevAlikhanUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class KabylbaevAlikhanUserController {

    private final KabylbaevAlikhanUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<KabylbaevAlikhanUserResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<KabylbaevAlikhanUserResponse>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<KabylbaevAlikhanUserResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody KabylbaevAlikhanRegisterRequest request) {
        return ResponseEntity.ok(userService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

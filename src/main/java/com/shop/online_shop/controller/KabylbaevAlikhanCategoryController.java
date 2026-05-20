package com.shop.online_shop.controller;

import com.shop.online_shop.dto.request.KabylbaevAlikhanCategoryRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanCategoryResponse;
import com.shop.online_shop.service.KabylbaevAlikhanCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class KabylbaevAlikhanCategoryController {

    private final KabylbaevAlikhanCategoryService categoryService;

    @PostMapping
    public ResponseEntity<KabylbaevAlikhanCategoryResponse> create(
            @Valid @RequestBody KabylbaevAlikhanCategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<KabylbaevAlikhanCategoryResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<KabylbaevAlikhanCategoryResponse>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<KabylbaevAlikhanCategoryResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody KabylbaevAlikhanCategoryRequest request) {
        return ResponseEntity.ok(categoryService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.shop.online_shop.service;

import com.shop.online_shop.dto.request.KabylbaevAlikhanProductRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface KabylbaevAlikhanProductService {
    KabylbaevAlikhanProductResponse create(KabylbaevAlikhanProductRequest request);
    KabylbaevAlikhanProductResponse getById(Long id);
    List<KabylbaevAlikhanProductResponse> getAll();
    KabylbaevAlikhanProductResponse update(Long id, KabylbaevAlikhanProductRequest request);
    void delete(Long id);
    Page<KabylbaevAlikhanProductResponse> search(String name, Long categoryId, Pageable pageable);
    String uploadImage(Long id, MultipartFile file);
}

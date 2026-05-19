package com.shop.online_shop.service;

import com.shop.online_shop.dto.request.KabylbaevAlikhanCategoryRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanCategoryResponse;

import java.util.List;

public interface KabylbaevAlikhanCategoryService {
    KabylbaevAlikhanCategoryResponse create(KabylbaevAlikhanCategoryRequest request);
    KabylbaevAlikhanCategoryResponse getById(Long id);
    List<KabylbaevAlikhanCategoryResponse> getAll();
    KabylbaevAlikhanCategoryResponse update(Long id, KabylbaevAlikhanCategoryRequest request);
    void delete(Long id);
}

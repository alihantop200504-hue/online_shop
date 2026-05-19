package com.shop.online_shop.service.impl;

import com.shop.online_shop.dto.request.KabylbaevAlikhanCategoryRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanCategoryResponse;
import com.shop.online_shop.entity.KabylbaevAlikhanCategory;
import com.shop.online_shop.mapper.KabylbaevAlikhanCategoryMapper;
import com.shop.online_shop.repository.KabylbaevAlikhanCategoryRepository;
import com.shop.online_shop.service.KabylbaevAlikhanCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KabylbaevAlikhanCategoryServiceImpl implements KabylbaevAlikhanCategoryService {

    private final KabylbaevAlikhanCategoryRepository categoryRepository;
    private final KabylbaevAlikhanCategoryMapper categoryMapper;

    @Override
    public KabylbaevAlikhanCategoryResponse create(KabylbaevAlikhanCategoryRequest request) {
        return categoryMapper.toResponse(categoryRepository.save(categoryMapper.toEntity(request)));
    }

    @Override
    public KabylbaevAlikhanCategoryResponse getById(Long id) {
        return categoryMapper.toResponse(categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found")));
    }

    @Override
    public List<KabylbaevAlikhanCategoryResponse> getAll() {
        return categoryRepository.findAll().stream().map(categoryMapper::toResponse).toList();
    }

    @Override
    public KabylbaevAlikhanCategoryResponse update(Long id, KabylbaevAlikhanCategoryRequest request) {
        KabylbaevAlikhanCategory category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}

package com.shop.online_shop.mapper;

import com.shop.online_shop.dto.request.KabylbaevAlikhanCategoryRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanCategoryResponse;
import com.shop.online_shop.entity.KabylbaevAlikhanCategory;
import org.springframework.stereotype.Component;

@Component
public class KabylbaevAlikhanCategoryMapper {
    public KabylbaevAlikhanCategoryResponse toResponse(KabylbaevAlikhanCategory category) {
        KabylbaevAlikhanCategoryResponse response = new KabylbaevAlikhanCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());
        return response;
    }
    public KabylbaevAlikhanCategory toEntity(KabylbaevAlikhanCategoryRequest request) {
        KabylbaevAlikhanCategory category = new KabylbaevAlikhanCategory();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        return category;
    }
}

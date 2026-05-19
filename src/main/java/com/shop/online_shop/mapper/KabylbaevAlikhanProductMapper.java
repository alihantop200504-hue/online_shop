package com.shop.online_shop.mapper;

import com.shop.online_shop.dto.request.KabylbaevAlikhanProductRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanProductResponse;
import com.shop.online_shop.entity.KabylbaevAlikhanProduct;
import org.springframework.stereotype.Component;

@Component
public class KabylbaevAlikhanProductMapper {
    public KabylbaevAlikhanProductResponse toResponse(KabylbaevAlikhanProduct product) {
        KabylbaevAlikhanProductResponse response = new KabylbaevAlikhanProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setImagePath(product.getImagePath());
        response.setCategoryName(product.getCategory().getName());
        response.setCreatedAt(product.getCreatedAt());
        return response;
    }
    public KabylbaevAlikhanProduct toEntity(KabylbaevAlikhanProductRequest request) {
        KabylbaevAlikhanProduct product = new KabylbaevAlikhanProduct();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        return product;
    }
}

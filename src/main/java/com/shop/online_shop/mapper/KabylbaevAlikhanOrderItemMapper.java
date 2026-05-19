package com.shop.online_shop.mapper;

import com.shop.online_shop.dto.response.KabylbaevAlikhanOrderItemResponse;
import com.shop.online_shop.entity.KabylbaevAlikhanOrderItem;
import org.springframework.stereotype.Component;

@Component
public class KabylbaevAlikhanOrderItemMapper {
    public KabylbaevAlikhanOrderItemResponse toResponse(KabylbaevAlikhanOrderItem item) {
        KabylbaevAlikhanOrderItemResponse response = new KabylbaevAlikhanOrderItemResponse();
        response.setId(item.getId());
        response.setProductName(item.getProduct().getName());
        response.setQuantity(item.getQuantity());
        response.setPrice(item.getPrice());
        return response;
    }
}

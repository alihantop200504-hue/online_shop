package com.shop.online_shop.mapper;

import com.shop.online_shop.dto.response.KabylbaevAlikhanOrderResponse;
import com.shop.online_shop.entity.KabylbaevAlikhanOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KabylbaevAlikhanOrderMapper {
    private final KabylbaevAlikhanOrderItemMapper orderItemMapper;

    public KabylbaevAlikhanOrderResponse toResponse(KabylbaevAlikhanOrder order) {
        KabylbaevAlikhanOrderResponse response = new KabylbaevAlikhanOrderResponse();
        response.setId(order.getId());
        response.setStatus(order.getStatus().name());
        response.setTotalPrice(order.getTotalPrice());
        response.setUsername(order.getUser().getUsername());
        response.setCreatedAt(order.getCreatedAt());
        response.setItems(order.getItems().stream()
                .map(orderItemMapper::toResponse)
                .toList());
        return response;
    }
}

package com.shop.online_shop.service;

import com.shop.online_shop.dto.request.KabylbaevAlikhanOrderRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanOrderResponse;
import com.shop.online_shop.enums.KabylbaevAlikhanOrderStatus;

import java.util.List;

public interface KabylbaevAlikhanOrderService {
    KabylbaevAlikhanOrderResponse create(KabylbaevAlikhanOrderRequest request);
    KabylbaevAlikhanOrderResponse getById(Long id);
    List<KabylbaevAlikhanOrderResponse> getAll();
    List<KabylbaevAlikhanOrderResponse> getByUserId(Long userId);
    KabylbaevAlikhanOrderResponse updateStatus(Long id, KabylbaevAlikhanOrderStatus status);
    void delete(Long id);
}

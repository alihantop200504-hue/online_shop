package com.shop.online_shop.service;

import com.shop.online_shop.dto.request.KabylbaevAlikhanRegisterRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanUserResponse;

import java.util.List;

public interface KabylbaevAlikhanUserService {
    KabylbaevAlikhanUserResponse getById(Long id);
    List<KabylbaevAlikhanUserResponse> getAll();
    KabylbaevAlikhanUserResponse update(Long id, KabylbaevAlikhanRegisterRequest request);
    void delete(Long id);
}

package com.shop.online_shop.service;

import com.shop.online_shop.dto.request.KabylbaevAlikhanLoginRequest;
import com.shop.online_shop.dto.request.KabylbaevAlikhanRegisterRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanAuthResponse;

public interface KabylbaevAlikhanAuthService {
    KabylbaevAlikhanAuthResponse register(KabylbaevAlikhanRegisterRequest request);
    KabylbaevAlikhanAuthResponse login(KabylbaevAlikhanLoginRequest request);

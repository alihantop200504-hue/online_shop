package com.shop.online_shop.controller;

import com.shop.online_shop.dto.request.KabylbaevAlikhanLoginRequest;
import com.shop.online_shop.dto.request.KabylbaevAlikhanRegisterRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanAuthResponse;
import com.shop.online_shop.service.KabylbaevAlikhanAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class KabylbaevAlikhanAuthController {

    private final KabylbaevAlikhanAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<KabylbaevAlikhanAuthResponse> register(
            @Valid @RequestBody KabylbaevAlikhanRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<KabylbaevAlikhanAuthResponse> login(
            @Valid @RequestBody KabylbaevAlikhanLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}

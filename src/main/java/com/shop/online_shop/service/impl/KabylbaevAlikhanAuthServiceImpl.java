package com.shop.online_shop.service.impl;

import com.shop.online_shop.dto.request.KabylbaevAlikhanLoginRequest;
import com.shop.online_shop.dto.request.KabylbaevAlikhanRegisterRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanAuthResponse;
import com.shop.online_shop.entity.KabylbaevAlikhanUser;
import com.shop.online_shop.enums.KabylbaevAlikhanRole;
import com.shop.online_shop.repository.KabylbaevAlikhanUserRepository;
import com.shop.online_shop.security.jwt.KabylbaevAlikhanJwtUtil;
import com.shop.online_shop.service.KabylbaevAlikhanAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KabylbaevAlikhanAuthServiceImpl implements KabylbaevAlikhanAuthService {

    private final KabylbaevAlikhanUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final KabylbaevAlikhanJwtUtil jwtUtil;
    private final KabylbaevAlikhanAsyncService asyncService;

    @Override
    public KabylbaevAlikhanAuthResponse register(KabylbaevAlikhanRegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("Email already exists");
        KabylbaevAlikhanUser user = new KabylbaevAlikhanUser();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? request.getRole() : KabylbaevAlikhanRole.USER);
        userRepository.save(user);
        asyncService.sendWelcomeNotification(user.getUsername());
        String token = jwtUtil.generateToken(user.getUsername());
        return new KabylbaevAlikhanAuthResponse(token, user.getUsername(), user.getRole().name());
    }

    @Override
    public KabylbaevAlikhanAuthResponse login(KabylbaevAlikhanLoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        KabylbaevAlikhanUser user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtUtil.generateToken(user.getUsername());
        return new KabylbaevAlikhanAuthResponse(token, user.getUsername(), user.getRole().name());
    }
}

package com.shop.online_shop.service.impl;

import com.shop.online_shop.dto.request.KabylbaevAlikhanRegisterRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanUserResponse;
import com.shop.online_shop.entity.KabylbaevAlikhanUser;
import com.shop.online_shop.mapper.KabylbaevAlikhanUserMapper;
import com.shop.online_shop.repository.KabylbaevAlikhanUserRepository;
import com.shop.online_shop.service.KabylbaevAlikhanUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KabylbaevAlikhanUserServiceImpl implements KabylbaevAlikhanUserService {

    private final KabylbaevAlikhanUserRepository userRepository;
    private final KabylbaevAlikhanUserMapper userMapper;

    @Override
    public KabylbaevAlikhanUserResponse getById(Long id) {
        return userMapper.toResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Override
    public List<KabylbaevAlikhanUserResponse> getAll() {
        return userRepository.findAll().stream().map(userMapper::toResponse).toList();
    }

    @Override
    public KabylbaevAlikhanUserResponse update(Long id, KabylbaevAlikhanRegisterRequest request) {
        KabylbaevAlikhanUser user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

package com.shop.online_shop.mapper;

import com.shop.online_shop.dto.response.KabylbaevAlikhanUserResponse;
import com.shop.online_shop.entity.KabylbaevAlikhanUser;
import org.springframework.stereotype.Component;

@Component
public class KabylbaevAlikhanUserMapper {
    public KabylbaevAlikhanUserResponse toResponse(KabylbaevAlikhanUser user) {
        KabylbaevAlikhanUserResponse response = new KabylbaevAlikhanUserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        response.setCreatedAt(user.getCreatedAt());
        return response;
    }
}

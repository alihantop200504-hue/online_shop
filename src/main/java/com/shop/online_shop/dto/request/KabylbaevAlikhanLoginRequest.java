package com.shop.online_shop.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class KabylbaevAlikhanLoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}

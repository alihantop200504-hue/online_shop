package com.shop.online_shop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KabylbaevAlikhanAuthResponse {
    private String token;
    private String username;
    private String role;
}

package com.shop.online_shop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KabylbaevAlikhanErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}

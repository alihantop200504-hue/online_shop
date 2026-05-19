package com.shop.online_shop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KabylbaevAlikhanOrderResponse {
    private Long id;
    private String status;
    private Double totalPrice;
    private String username;
    private LocalDateTime createdAt;
    private List<KabylbaevAlikhanOrderItemResponse> items;
}

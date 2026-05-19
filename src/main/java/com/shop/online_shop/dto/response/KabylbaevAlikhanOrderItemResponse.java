package com.shop.online_shop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KabylbaevAlikhanOrderItemResponse {
    private Long id;
    private String productName;
    private Integer quantity;
    private Double price;
}

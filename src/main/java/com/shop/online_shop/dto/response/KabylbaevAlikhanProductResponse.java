package com.shop.online_shop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KabylbaevAlikhanProductResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String imagePath;
    private String categoryName;
    private LocalDateTime createdAt;
}

package com.shop.online_shop.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KabylbaevAlikhanOrderRequest {
    @NotNull
    private Long userId;
    @NotNull
    private List<KabylbaevAlikhanOrderItemRequest> items;
}

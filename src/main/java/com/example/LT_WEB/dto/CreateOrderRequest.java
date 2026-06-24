package com.example.LT_WEB.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {

    private Long userId;

    private Long cartId;
}
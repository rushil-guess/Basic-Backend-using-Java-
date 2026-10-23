package com.rushil.demo.model.dto;

import java.time.LocalDate;
import java.util.List;

public record OrderResponse(String orderId, String CustomerName, String email, String status, LocalDate orderDate,
                            List<OrderItemResponse> items) {
}

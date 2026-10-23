package com.rushil.demo.model.dto;

import java.util.List;

public record OrderRequest(String Name, String email, List<OrderItem> items) {
}

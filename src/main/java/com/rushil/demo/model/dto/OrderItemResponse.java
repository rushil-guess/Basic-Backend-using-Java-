package com.rushil.demo.model.dto;

import java.math.BigDecimal;

public record OrderItemResponse(String prodName, int quantity, BigDecimal price) {

}

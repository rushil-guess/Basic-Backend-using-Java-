package com.rushil.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderItem {
    @Id
    private int Id;
    @ManyToOne
    private Job jOb;
    private int quantity;
    private BigDecimal totalprice;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

}

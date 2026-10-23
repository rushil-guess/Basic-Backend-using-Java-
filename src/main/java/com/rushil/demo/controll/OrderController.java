package com.rushil.demo.controll;


import com.rushil.demo.model.dto.OrderRequest;
import com.rushil.demo.model.dto.OrderResponse;
import com.rushil.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("place")
    public ResponseEntity<OrderResponse> placeorder(@RequestBody OrderRequest orderrequest){
        OrderResponse orderResponse=service.placeorder(orderrequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }
    @GetMapping("orders")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> orders = service.getAllOrders();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
}

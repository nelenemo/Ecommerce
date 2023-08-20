package com.product.ecommerce.controller;

import com.product.ecommerce.dto.OrderAck;
import com.product.ecommerce.dto.OrderRequest;
import com.product.ecommerce.exception.InsufficientMoneyException;
import com.product.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/api")
public class OrderController {

    @Autowired
    public OrderService orderService;

    @PostMapping("/placeOrder")
    public OrderAck placeOrders(@RequestBody OrderRequest orderRequest) {
        return orderService.placingOrder(orderRequest);
    }
}

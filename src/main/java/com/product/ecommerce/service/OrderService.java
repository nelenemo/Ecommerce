package com.product.ecommerce.service;

import com.product.ecommerce.dto.OrderAck;
import com.product.ecommerce.dto.OrderRequest;
import com.product.ecommerce.exception.InsufficientMoneyException;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {
    public OrderAck placingOrder(OrderRequest orderRequest) throws InsufficientMoneyException;
}

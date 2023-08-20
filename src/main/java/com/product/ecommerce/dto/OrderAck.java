package com.product.ecommerce.dto;

import com.product.ecommerce.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderAck {
    private String status;
    private double totalAmount;
    private PaymentInfo paymentInfo;
}

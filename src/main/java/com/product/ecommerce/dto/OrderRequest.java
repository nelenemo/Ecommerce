package com.product.ecommerce.dto;

import com.product.ecommerce.entity.OrderInfo;
import com.product.ecommerce.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
    private OrderInfo orderInfo;
    private PaymentInfo paymentInfo;
}

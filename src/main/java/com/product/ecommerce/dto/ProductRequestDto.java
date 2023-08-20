package com.product.ecommerce.dto;

import lombok.Data;

@Data

public class ProductRequestDto {
    private Long productId;
    private String productName;
    private double productPrice;
    private int productQuantity;

}

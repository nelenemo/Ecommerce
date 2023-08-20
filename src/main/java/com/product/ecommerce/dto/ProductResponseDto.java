package com.product.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductResponseDto {
    private Long productId;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private double totalPrice;




}

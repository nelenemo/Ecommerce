package com.product.ecommerce.service;

import com.product.ecommerce.dto.ProductRequestDto;
import com.product.ecommerce.dto.ProductResponseDto;
import com.product.ecommerce.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void insertProducts(ProductRequestDto productRequestDto);


    List<ProductResponseDto> getAllProduct();

    Optional<Product> getProductById(Long id);
}

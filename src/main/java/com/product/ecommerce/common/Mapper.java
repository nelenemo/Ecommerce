package com.product.ecommerce.common;

import com.product.ecommerce.dto.ProductRequestDto;
import com.product.ecommerce.dto.ProductResponseDto;
import com.product.ecommerce.entity.Product;

public interface Mapper {

public Product DtoToProduct(ProductRequestDto productRequestDto);

public ProductResponseDto ProductToDto(Product product);

}

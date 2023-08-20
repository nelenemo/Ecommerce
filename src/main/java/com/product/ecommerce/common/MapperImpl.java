package com.product.ecommerce.common;

import com.product.ecommerce.dto.ProductRequestDto;
import com.product.ecommerce.dto.ProductResponseDto;
import com.product.ecommerce.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements Mapper {
    public MapperImpl() {

    }

    @Override
    public Product DtoToProduct(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setProductId(productRequestDto.getProductId());
        product.setProductName(productRequestDto.getProductName());
        product.setProductPrice(productRequestDto.getProductPrice());
        product.setProductQuantity(productRequestDto.getProductQuantity());

        return product;
    }

    @Override

    public ProductResponseDto ProductToDto(Product product) {
        ProductResponseDto productResponseDto=new ProductResponseDto();
        productResponseDto.setProductId(product.getProductId());
        productResponseDto.setProductName(product.getProductName());
        productResponseDto.setProductPrice(productResponseDto.getProductPrice());////////
        productResponseDto.setProductQuantity(product.getProductQuantity());
        productResponseDto.setTotalPrice(product.getProductPrice()*product.getProductQuantity());
        return productResponseDto;
    }
}

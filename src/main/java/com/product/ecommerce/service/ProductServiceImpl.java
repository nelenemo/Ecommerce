package com.product.ecommerce.service;

import com.product.ecommerce.common.Mapper;
import com.product.ecommerce.dto.ProductRequestDto;
import com.product.ecommerce.dto.ProductResponseDto;
import com.product.ecommerce.entity.Product;
import com.product.ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    public Mapper mapper;
    
    @Autowired
    public ProductRepo productRepo;

    @Override

    public void insertProducts(ProductRequestDto productRequestDto) {
        Product productt = mapper.DtoToProduct(productRequestDto);

        productRepo.save(productt);
        System.out.println(productt.getProductId());
        System.out.println(productt.getProductName());

    }

    @Override

    public List<ProductResponseDto> getAllProduct() {
        List<Product> products = productRepo.findAll();
        return products
                .stream()
                .map(mapper::ProductToDto)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<Product> getProductById(Long id) {

        return productRepo.findById(id);
    }


}

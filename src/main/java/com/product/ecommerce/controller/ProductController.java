package com.product.ecommerce.controller;

import com.product.ecommerce.dto.ProductRequestDto;
import com.product.ecommerce.dto.ProductResponseDto;
import com.product.ecommerce.entity.Product;
import com.product.ecommerce.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/insertProduct")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String insertProduct(@RequestBody ProductRequestDto productRequestDto) {
        productService.insertProducts(productRequestDto);
        return "The product has been added";
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public List<ProductResponseDto> getAll(){
        return  productService.getAllProduct();

    }

    @GetMapping("/id/{productId}")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Optional<Product> getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }



}

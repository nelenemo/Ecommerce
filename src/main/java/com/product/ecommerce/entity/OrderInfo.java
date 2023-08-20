package com.product.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderId;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="product_id")
    private String productName;
    private String orderStatus;


}

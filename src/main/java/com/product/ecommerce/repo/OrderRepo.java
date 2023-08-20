package com.product.ecommerce.repo;

import com.product.ecommerce.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OrderRepo extends JpaRepository<OrderInfo, Long> {
}

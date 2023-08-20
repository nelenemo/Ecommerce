package com.product.ecommerce.repo;

import com.product.ecommerce.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, Long> {
}

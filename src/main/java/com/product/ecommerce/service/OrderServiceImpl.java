package com.product.ecommerce.service;

import com.product.ecommerce.dto.OrderAck;
import com.product.ecommerce.dto.OrderRequest;
import com.product.ecommerce.entity.OrderInfo;
import com.product.ecommerce.entity.PaymentInfo;
import com.product.ecommerce.entity.Product;
import com.product.ecommerce.exception.InsufficientMoneyException;
import com.product.ecommerce.repo.OrderRepo;
import com.product.ecommerce.repo.PaymentInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.product.ecommerce.util.PaymentValidation.validatePaymentInfo;

@Service


public class OrderServiceImpl implements OrderService {
    @Autowired
    public OrderRepo orderRepo;
    @Autowired
    public PaymentInfoRepo paymentInfoRepo;

@Override
@Transactional(propagation = Propagation.REQUIRED)
    public OrderAck placingOrder(OrderRequest orderRequest)  {
        OrderInfo orderInfo = orderRequest.getOrderInfo();
        orderInfo = orderRepo.save(orderInfo);
        PaymentInfo paymentInfo = orderRequest.getPaymentInfo();

        validatePaymentInfo(paymentInfo);
        orderInfo.setProductName(paymentInfo.getProductName());
        orderRepo.save(orderInfo);
        paymentInfoRepo.save(paymentInfo);

//        PaymentInfo paymentInfoSaved = paymentInfoRepo.save(paymentInfo);

        return new OrderAck("Success", paymentInfo.getAmount(), paymentInfo);
    }
}

package com.product.ecommerce.util;

import com.product.ecommerce.entity.PaymentInfo;
import com.product.ecommerce.entity.Product;
import com.product.ecommerce.exception.InsufficientMoneyException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentValidation {

    public static Map<String, Double> paymentDetails= new HashMap<>();

    static {
        paymentDetails.put("Car", 200000.00);
        paymentDetails.put("Bike", 4000000.00);
    }

    public static boolean validatePaymentInfo(PaymentInfo paymentInfo){
        if(paymentInfo.getAmount()<paymentDetails.get(paymentInfo.getProductName())){
            throw new InsufficientMoneyException("Insufficient Amount");
        }
        else
            return true;

    }
}

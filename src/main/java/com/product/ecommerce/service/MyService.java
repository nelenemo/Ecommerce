//package com.product.ecommerce.service;
//import com.product.ecommerce.entity.Product;
//import org.hibernate.boot.model.relational.Database;
//
//import javax.cache.Cache;
//import java.util.logging.Logger;
//
//public class MyService {
//    private static final Logger logger = Logger.getLogger(MyService.class.getName());
//
//    // Assume you have instances of cache and database in your class
//    private Cache<Product> cache; // Replace "Cache<Product>" with your actual cache class
//    private Product product1;   // Replace "Database" with your actual database class
//
//    public Product getProduct(String key) {
//        Product product = cache.get(key);
//
//        if (product != null) {
//            logger.info("Fetched from cache: " + key);
//            return product;
//        }
//
//        product = product1.fetchProduct(key);
//        logger.info("Fetched from database: " + key);
//
//        cache.put(key, product);
//        return product;
//    }
//}

//package com.product.ecommerce.config;
//
//import com.product.ecommerce.entity.Product;
//
//import net.sf.ehcache.management.CacheConfiguration;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.jcache.JCacheCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.cache.Caching;
//import javax.cache.spi.CachingProvider;
//import java.time.Duration;
//
//@Configuration
//public class EhcacheConfig {
//
//    @Bean
//    public CacheManager EhcacheManager() {
//
//        CacheConfiguration<String, Product> cachecConfig = CacheConfigurationBuilder
//                .newCacheConfigurationBuilder(String.class,
//                        Product.class,
//                        ResourcePoolsBuilder.newResourcePoolsBuilder()
//                                .offheap(10, MemoryUnit.MB)
//                                .build())
//                .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(10)))
//                .build();
//
//        CachingProvider cachingProvider = Caching.getCachingProvider();
//        CacheManager cacheManager = cachingProvider.getCacheManager();
//
//        javax.cache.configuration.Configuration<String, Product> configuration = Eh107Configuration.fromEhcacheCacheConfiguration(cachecConfig);
//        cacheManager.createCache("cacheStore", configuration);
//        return cacheManager;
//    }
//}

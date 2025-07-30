package com.myapp.spring;

import com.myapp.spring.service.TradeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching

public class TradeReconciliationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeReconciliationApplication.class, args);
    }

}

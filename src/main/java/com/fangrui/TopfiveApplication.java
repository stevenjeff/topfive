package com.fangrui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TopfiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(TopfiveApplication.class, args);
    }
}

package com.skyeagle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.skyeagle.servlet","com.skyeagle.filter"})
public class HelloSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);
    }

}

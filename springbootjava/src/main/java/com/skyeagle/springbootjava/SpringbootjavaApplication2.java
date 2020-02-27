package com.skyeagle.springbootjava;

import com.skyeagle.springbootjava.service.UserService;
import com.skyeagle.springbootjava.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootjavaApplication2 implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        //启动springboot程序和spring容器
        SpringApplication.run(SpringbootjavaApplication2.class, args);
    }

    //业务方法入口
    @Override
    public void run(String... args) throws Exception {
        System.out.println(userService.sayHello("skyeagle"));
    }
}

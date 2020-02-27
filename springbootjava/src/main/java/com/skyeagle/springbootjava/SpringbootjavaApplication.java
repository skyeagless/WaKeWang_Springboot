package com.skyeagle.springbootjava;

import com.skyeagle.springbootjava.service.UserService;
import com.skyeagle.springbootjava.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@SpringBootApplication
public class SpringbootjavaApplication {

    public static void main(String[] args) {
        //返回一个spring容器对象
        ApplicationContext applicationContext = SpringApplication.run(SpringbootjavaApplication.class, args);
        UserService userService = applicationContext.getBean("userServiceImpl", UserServiceImpl.class);
        String hi = userService.sayHello("skyeagle");
        System.out.println(hi);
    }

}

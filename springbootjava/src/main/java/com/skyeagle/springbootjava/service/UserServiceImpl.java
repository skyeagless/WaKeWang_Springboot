package com.skyeagle.springbootjava.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name) {
        return "Hi "+ name;
    }
}

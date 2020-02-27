package com.skyeagle.controller;

import com.skyeagle.model.Users;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//返回spring或者json
public class WebController {
    @RequestMapping("/user")
    public Object user(){
        Users user = new Users();
        user.setId(1);
        user.setName("skyeagle");
        user.setPhone("32323");
        return user;
    }
}

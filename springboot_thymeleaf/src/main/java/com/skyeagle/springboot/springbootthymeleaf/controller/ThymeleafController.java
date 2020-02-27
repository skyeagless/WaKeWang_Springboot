package com.skyeagle.springboot.springbootthymeleaf.controller;

import com.skyeagle.springboot.springbootthymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class ThymeleafController {
    @RequestMapping("/boot/index")
    public String index(Model model){
        model.addAttribute("data","Spring boot 集成 Thymeleaf!");

        User user = new User();
        user.setId(1);
        user.setNick("skyeagle");
        user.setPhone("1388888888");
        user.setAddress("sichuan");
        user.setEmail("111@qq.com");
        model.addAttribute("user",user);

        List<User> userList = new ArrayList<>();
        Map<String,User> userMap = new HashMap<String,User>();
        User[] userArray = new User[12];

        //复杂的
        Map<String,Object> map = new HashMap<>();

        for (int i = 0; i < 12; i++) {
            User u = new User();
            u.setId(1);
            u.setNick("skyeagle");
            u.setPhone("1388888888");
            u.setAddress("sichuan");
            u.setEmail("111@qq.com");
            userList.add(u);
            userMap.put(String.valueOf(i),u);
            userArray[i] = u;
        }

        List<User> userList2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User u = new User();
            u.setId(1);
            u.setNick("skyeagle"+i);
            u.setPhone("13888843243"+i);
            u.setAddress(i+"sichuan");
            u.setEmail("111@qq.com"+i);
            userList2.add(u);
        }

        map.put("1",userList);
        map.put("2",userList2);
        model.addAttribute("userList",userList);
        model.addAttribute("userMap",userMap);
        model.addAttribute("userArray",userArray);
        model.addAttribute("map",map);
        model.addAttribute("sex",1);
        model.addAttribute("nowDate",new Date());
        model.addAttribute("nowDateStr","2019-12-02 17:37:00");
        int[] intArray = new int[]{1,2,3};
        model.addAttribute("intArray",intArray);
        return "index";
    }
}

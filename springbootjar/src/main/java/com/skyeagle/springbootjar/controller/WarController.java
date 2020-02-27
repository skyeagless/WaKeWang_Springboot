package com.skyeagle.springbootjar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WarController {
    @GetMapping("/json")
    public Object json(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",318);
        map.put("status",1);
        map.put("name","buy phone");
        return map;
    }
}

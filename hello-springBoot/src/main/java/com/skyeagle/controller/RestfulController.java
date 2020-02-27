package com.skyeagle.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//开发接口，返回json数据的程序
@RestController
public class RestfulController {
    //查询数据
    @GetMapping("/order/{id}/{status}")
    public Object order(@PathVariable("id") Integer id, @PathVariable("status") Integer status){
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("id",id);
        map.put("status",status);
        map.put("name","buy phone");
        return map;
    }

    //新增数据
    @PostMapping("/order/{status}/{id}")
    public Object order2(@PathVariable("id") Integer id, @PathVariable("status") Integer status){
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("id",id);
        map.put("status",status);
        map.put("name","buy phone");
        return map;
    }


}

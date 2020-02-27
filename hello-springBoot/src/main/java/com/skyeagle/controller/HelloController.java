package com.skyeagle.controller;

import com.skyeagle.model.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //读取自定义配置
    @Value("${info.site.url}")
    private String url;
    @Value("${info.site.tel}")
    private String tel;

    @Autowired
    private ConfigInfo configInfo;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring";
    }


    @RequestMapping("/config")
    public String config(){
        return url + "---" + tel + "-->"+ configInfo.getUrl()+ "---" + configInfo.getTel();
    }
}

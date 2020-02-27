package com.skyeagle.springboot.controller;

import com.skyeagle.springboot.entity.UserInfo;
import com.skyeagle.springboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.skyeagle.springboot.utils.commons.Constants.PAGE_SIZE;

@Controller
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/all/users")
    public String users(Model model, @RequestParam(value = "p",required = false) Integer curPage){
        if(curPage == null){
            curPage = 1;
        }
        int startRow = (curPage - 1) * PAGE_SIZE;
        int limit = PAGE_SIZE;
        List<UserInfo> userInfoList = userInfoService.getUserInfoByPage(startRow,limit);
        int totalRows = userInfoService.getUserInfoByTotals();
        int totalPages = totalRows / PAGE_SIZE + (( totalRows % PAGE_SIZE == 0 ) ? 0 : 1);

        model.addAttribute("userInfoList",userInfoList);
        model.addAttribute("curPage",curPage);
        model.addAttribute("totalPages",totalPages);
        return "users";
    }

    //去添加用户（点链接）
    @GetMapping("/all/user")
    public String toAddUser(){
        return "user";
    }

    //添加用户（上传信息）
    @PostMapping("/all/user")
    public String addUser(UserInfo userInfo){
        userInfoService.addUserInfo(userInfo);
        return "redirect:/all/users";
    }

    //去修改用户（点链接）
    /**
     * @RequestParam 注解是获取静态URL传入的参数
     * @PathVariable 是获取请求路径中的变量作为参数
     **/
    @GetMapping("/all/user/{id}")
    public String toUpdateUser(Model model, @PathVariable("id") Integer id){
       UserInfo userInfo = userInfoService.getUserInfoById(id);
       model.addAttribute("userInfo",userInfo);
       return "user";
    }

    //修改用户（上传信息）
    @PutMapping("/all/user")
    public String updateUser(UserInfo userInfo){
        userInfoService.updateUserInfo(userInfo);
        return "redirect:/all/users";
    }

    @DeleteMapping("/all/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userInfoService.deleteUserInfoById(id);
        return "redirect:/all/users";
    }

}

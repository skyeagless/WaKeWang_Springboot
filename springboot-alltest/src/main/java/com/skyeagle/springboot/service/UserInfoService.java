package com.skyeagle.springboot.service;

import com.skyeagle.springboot.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    public int addUserInfo(UserInfo userInfo);
    public int deleteUserInfoById(Integer id);
    public int updateUserInfo(UserInfo userInfo);
    public UserInfo getUserInfoById(Integer id);
    public List<UserInfo> getUserInfoByPage(Integer startRow, Integer limit);
    public int getUserInfoByTotals();
}

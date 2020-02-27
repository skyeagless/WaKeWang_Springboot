package com.skyeagle.springboot.service.impl;

import com.skyeagle.springboot.dao.UserInfoMapper;
import com.skyeagle.springboot.entity.UserInfo;
import com.skyeagle.springboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public int deleteUserInfoById(Integer id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public UserInfo getUserInfoById(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserInfo> getUserInfoByPage(Integer startRow, Integer limit) {
        return userInfoMapper.selectUserInfoByPage(startRow,limit);
    }

    @Override
    public int getUserInfoByTotals() {
        return userInfoMapper.selectUserInfoByTotals();
    }
}

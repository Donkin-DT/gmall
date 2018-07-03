package com.atguigu.service;

import com.atguigu.bean.UserAddress;
import com.atguigu.bean.UserInfo;

import java.util.List;

public interface UserService {
    public List<UserInfo> getUserInfoList(UserInfo userInfoQuery);

    public UserInfo getUserInfo(UserInfo userInfoQuery);

    public void deleteUserInfo(UserInfo userInfoQuery);

    public void addUserInfo(UserInfo userInfo);

    public void updateUserInfo(UserInfo userInfo);

    public List<UserAddress> getUserAddressList(String userId);
}

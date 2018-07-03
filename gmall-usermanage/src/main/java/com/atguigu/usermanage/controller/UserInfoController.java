package com.atguigu.usermanage.controller;

import com.atguigu.bean.UserInfo;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserInfo")
    public UserInfo getUserInfo(UserInfo userInfoQuery){
        UserInfo userInfo = userService.getUserInfo(userInfoQuery);
        return userInfo;
    }

    @RequestMapping(value = "/getUserInfoList")
    public List<UserInfo> getUserInfoList(UserInfo userInfo){
        List<UserInfo> userInfoList = userService.getUserInfoList(userInfo);
        return userInfoList;
    }

    @RequestMapping(value = "/addUserInfo",method = RequestMethod.POST)
    public String addUserInfo(UserInfo userInfo){
        userService.addUserInfo(userInfo);
        return "success";
    }

    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public String updateUserInfo(UserInfo userInfo){
        userService.updateUserInfo(userInfo);
        return "success";
    }

    @RequestMapping(value = "/deleteUserInfo",method = RequestMethod.POST)
    public String deleteUserInfo (UserInfo userInfoQuery){
        userService.deleteUserInfo(userInfoQuery);
        return "success";
    }
}

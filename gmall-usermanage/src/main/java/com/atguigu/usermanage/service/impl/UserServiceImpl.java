package com.atguigu.usermanage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.bean.UserAddress;
import com.atguigu.bean.UserInfo;
import com.atguigu.service.UserService;

import com.atguigu.usermanage.mapper.UserAddressMapper;
import com.atguigu.usermanage.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserAddressMapper userAddressMapper;

    @Override
    public List<UserInfo> getUserInfoList(UserInfo userInfoQuery) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%"+userInfoQuery.getLoginName()+"%");

        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        return userInfos;
    }

    @Override
    public UserInfo getUserInfo(UserInfo userInfoQuery) {
        UserInfo userInfo = userInfoMapper.selectOne(userInfoQuery);
        return userInfo;
    }

    @Override
    public void deleteUserInfo(UserInfo userInfoQuery) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%"+userInfoQuery.getLoginName()+"%");
        userInfoMapper.deleteByExample(example);
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        //不覆盖默认值添加数据
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);

        /*Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%" +userInfo.getLoginName()+"%");
        userInfo.setLoginName(null);
        userInfoMapper.updateByExampleSelective(userInfo,example);*/
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddressQuery = new UserAddress();
        userAddressQuery.setUserId(userId);
        List<UserAddress> userAddressList = userAddressMapper.select(userAddressQuery);
        return userAddressList;
    }
}

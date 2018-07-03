package com.atguigu.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.bean.UserAddress;
import com.atguigu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    @Reference
    UserService userService;

    @RequestMapping("/trade")
    @ResponseBody
    public String trade(HttpServletRequest request){
        //商品信息
        //地址信息
       String userId = request.getParameter("userId");
       List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        String jsonString = JSON.toJSONString(userAddressList);
        return jsonString;
        //支付信息
    }

    @RequestMapping("/saveOrder")
    @ResponseBody
    public String saveOrder(HttpServletRequest request){
        int localPort = request.getLocalPort();
        return "user-port" + localPort;
    }
}

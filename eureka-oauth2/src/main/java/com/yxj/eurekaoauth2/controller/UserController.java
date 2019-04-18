package com.yxj.eurekaoauth2.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class UserController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("user")
    public Principal user(Principal user){
        return user;
    }
    @RequestMapping("/common")
    public String common(){
        return "这是可见的，不需要认证的";
    }

    @PreAuthorize("hasAuthority('select')")
    @RequestMapping("/select")
    public String select(){
        return "这是需要select权限的";
    }
    @RequestMapping("/update")
    public String update(){
        return "这是需要update权限的";
    }
    @RequestMapping("/logoutSuccess")
    public String logoutSuccess(){
        return "注销成功";
    }
    @RequestMapping("/loginSuccess")
    public String loginSuccess(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return JSONObject.toJSONString(authentication);
    }
    @RequestMapping("/loginFail")
    public String loginFail(HttpServletRequest request){
        return "用户名或密码错误！";
    }
}

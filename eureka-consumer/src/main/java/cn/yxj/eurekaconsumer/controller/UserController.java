package cn.yxj.eurekaconsumer.controller;

import cn.yxj.eurekaapi.entity.User;
import cn.yxj.eurekaconsumer.component.UserConfig;
import cn.yxj.eurekaconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserConfig userConfig;
    @RequestMapping("/getUsers")
    public List<User> getUser(){
        return userService.getUser();
    }

    @RequestMapping("/addUser")
    public User addUser(User user){
        return userService.addUser(user);
    }
    @RequestMapping("/sendMessage")
    public String sendMessage(String message){
//        int i = 10/0;
        return userService.sendMessage(message);
}
    @RequestMapping("userConfig")
    public boolean getUserConfig(){
        return  new UserConfig() == userConfig;
    }
}

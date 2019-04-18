package cn.yxj.eurekaprovider02.controller;

import cn.yxj.eurekaapi.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping("/getUsers")
    private List<User> getUser(){
        List<User> users = new ArrayList<>();
        users.add(new User("yangxj01","123",21));
        users.add(new User("yangxj02","123",21));
        return users;
    }
}

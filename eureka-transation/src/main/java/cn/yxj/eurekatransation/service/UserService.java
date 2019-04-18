package cn.yxj.eurekatransation.service;

import cn.yxj.eurekatransation.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
@Service
public class UserService {
    @Autowired
    UserService_1 userService_1;
    @Autowired
    UserService_2 userService_2;

//    @Transactional
    public void updateUser(String name,String name2){
//        userService_1.updateUser(name);
//        userService_2.updateUser(name2);
        userService_1.updateUser(name,name2);
    }

}

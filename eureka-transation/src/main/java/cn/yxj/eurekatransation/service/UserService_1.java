package cn.yxj.eurekatransation.service;

import cn.yxj.eurekatransation.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService_1 {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService_2 userService2;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    // 开启新的事务，若原来的事务发生异常，不会导致该事务回滚
    public void updateUser(String name){
        userMapper.updateUser(name);
    }

    public void updateUser2(String name){
      try{
          userMapper.updateUser(name);
          int i=10/0;
      }catch (Exception e){
          e.printStackTrace();
      }

    }
    @Transactional
    public void updateUser(String name, String name2) {
            updateUser2(name);
    }
}

package cn.yxj.eurekatransation.service;

import cn.yxj.eurekatransation.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService_2 {
    @Autowired
    UserMapper userMapper;
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    //以非事务方式执行，出现异常不触发事务回滚
    public void updateUser(String name){
        userMapper.updateUser(name);
        int i = 10/0;
    }
}

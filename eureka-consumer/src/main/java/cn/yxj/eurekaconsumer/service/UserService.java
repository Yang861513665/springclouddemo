package cn.yxj.eurekaconsumer.service;

import cn.yxj.eurekaapi.entity.User;
import cn.yxj.eurekaconsumer.component.UserServiceFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/**
 * path: 定义当前FeignClient的统一前缀
 * */
@FeignClient(value = "provider",fallbackFactory = UserServiceFallBackFactory.class,path = "user")
public interface UserService {
    @RequestMapping("/getUsers")
    List<User> getUser();
    @RequestMapping("/addUser")
    User addUser(User user);
    @RequestMapping("/sendMessage")
    String sendMessage(@RequestParam(value = "message") String message);
}

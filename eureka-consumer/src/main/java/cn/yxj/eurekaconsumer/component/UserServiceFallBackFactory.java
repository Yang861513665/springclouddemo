package cn.yxj.eurekaconsumer.component;

import cn.yxj.eurekaapi.entity.User;
import cn.yxj.eurekaconsumer.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceFallBackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public List<User> getUser() {
                List<User> users = new ArrayList<>();
                users.add(new User("服务终止","服务终止",-1));
                return users;
            }

            @Override
            public User addUser(User user) {
                return new User("服务终止","添加失败",-1);
            }

            @Override
            public String sendMessage(String message) {
                return throwable.getMessage();
            }
        };
    }
}

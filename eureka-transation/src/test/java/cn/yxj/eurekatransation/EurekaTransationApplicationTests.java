package cn.yxj.eurekatransation;

import cn.yxj.eurekatransation.service.UserService;
import cn.yxj.eurekatransation.service.UserService_1;
import cn.yxj.eurekatransation.service.UserService_2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaTransationApplicationTests {

    @Autowired
    UserService userService;
    @Test
    public void contextLoads() {
        userService.updateUser("yangxj01","yangxj02");
    }

}

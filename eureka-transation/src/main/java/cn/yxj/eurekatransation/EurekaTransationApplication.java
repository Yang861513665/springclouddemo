package cn.yxj.eurekatransation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class EurekaTransationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaTransationApplication.class, args);
    }
}

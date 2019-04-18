package cn.yxj.eurekaprovider02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProvider02Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider02Application.class, args);
    }
}

package cn.yxj.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author yangxj
 * @date 2019-3-6 14:46
 */
@Service
public class RabbitService {

    @RabbitListener(queues = "test.news")
    public void receive(String message){
        System.out.println("接收到消息："+message);
    }
}

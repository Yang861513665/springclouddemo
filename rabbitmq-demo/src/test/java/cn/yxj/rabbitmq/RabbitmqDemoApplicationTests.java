package cn.yxj.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqDemoApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;
    @Autowired

    @Test
    public void contextLoads() {
        rabbitTemplate.convertAndSend("test.topic","test.abc","hello rabbitmq queue!");
        amqpAdmin.declareQueue(new Queue("test.info"));
        amqpAdmin.declareExchange(new TopicExchange("test.topic"));
        amqpAdmin.declareBinding(new Binding("test.info",Binding.DestinationType.QUEUE,"test.topic","test.*",null));
    }
    @Test
    public void testElastic(){

    }
}

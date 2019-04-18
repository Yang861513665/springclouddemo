package cn.yxj.rabbitmq.service.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangxj
 * @date 2019-3-6 15:28
 * @desciprtion  修改默认的序列化器
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}

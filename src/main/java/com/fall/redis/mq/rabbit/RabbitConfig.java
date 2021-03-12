package com.fall.redis.mq.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author xql132@zcsmart.com
 * @date 2021/3/12
 * @time 15:43
 * @description
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue firstQueue() {
        return new Queue("enjoy");
    }
}

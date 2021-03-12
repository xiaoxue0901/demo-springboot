package com.fall.redis.mq.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/12
 * @time 15:46
 * @description
 */
@Component
@RabbitListener(queues = "enjoy")
public class Receiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("consumer receive msg:"+msg);
    }
}

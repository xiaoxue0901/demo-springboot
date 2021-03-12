package com.fall.redis.mq.rabbit.produce;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/12
 * @time 15:45
 * @description
 */
@Component
public class Sender {
    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send() {
        for (int i = 0; i < 10; i++) {
             new Thread(()->{
                 System.out.println("product create message, thread:"+ Thread.currentThread().getId());
                 rabbitTemplate.convertAndSend("enjoy", "product a message"+Thread.currentThread().getId());
            }).start();
        }

    }
}

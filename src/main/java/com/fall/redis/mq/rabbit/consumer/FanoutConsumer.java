package com.fall.redis.mq.rabbit.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/17
 * @time 9:44
 * @description
 */
@Component
@RabbitListener(queues = {"fanout1", "fanout2"})
@Slf4j
public class FanoutConsumer {

    @RabbitHandler
    public void process(String message) {
        log.info("fanout consumer receiver message:{}", message);
    }
}

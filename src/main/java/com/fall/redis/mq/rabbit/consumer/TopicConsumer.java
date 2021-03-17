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
@RabbitListener(queues = {"fall.beauty","fall.direct"})
@Slf4j
public class TopicConsumer {

    @RabbitHandler
    public void process(String message) {
        log.info("topic consumer receiver message:{}", message);
    }
}

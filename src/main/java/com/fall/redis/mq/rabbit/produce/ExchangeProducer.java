package com.fall.redis.mq.rabbit.produce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/17
 * @time 9:41
 * @description
 */
@Component
@Slf4j
public class ExchangeProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        log.info("product send message start");
        // direct exchange
        rabbitTemplate.convertAndSend("DIRECT_EXCHANGE", "fall.direct", "direct message");
        // topic exchange
        rabbitTemplate.convertAndSend("TOPIC_EXCHANGE", "fall.*", "topic message");
        // fanout exchange
        rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "", "fanout message");
        log.info("product send message end");
    }
}

package com.fall.redis.mq.rabbit.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/12
 * @time 11:59
 * @description 消费者
 */
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${order.fanout.queue}", autoDelete = "false"), exchange =
@Exchange(value = "${order.fanout.exchange}", type = ExchangeTypes.FANOUT)))
@Slf4j
public class Consumer {

    @RabbitHandler
    public void processMessage(String msg) {
        log.info("Receiving Message:---:{}", msg);
    }
}

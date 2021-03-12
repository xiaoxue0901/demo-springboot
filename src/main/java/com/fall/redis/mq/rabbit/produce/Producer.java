package com.fall.redis.mq.rabbit.produce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/11
 * @time 15:40
 * @description 1. 创建生产者, 定义发送消息的方法: 使用rabbitMQ发送消息.
 */
@Component
@Slf4j
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${order.fanout.exchange}")
    private String exchangeName;

    public void sendMsg() {
        String orderId = UUID.randomUUID().toString();
        String message = "你的订单信息是:".concat(orderId).concat("; 日期是:").concat(LocalDateTime.now().toString());
        log.info("生产者产生任务:{}", message);
        rabbitTemplate.convertAndSend(exchangeName, message);
    }
}

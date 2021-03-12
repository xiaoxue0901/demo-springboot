package com.fall.redis.controller;

import com.fall.redis.mq.rabbit.bean.UserAddress;
import com.fall.redis.mq.rabbit.consumer.OrderService;
import com.fall.redis.mq.rabbit.produce.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/12
 * @time 13:53
 * @description
 */
@RestController
@RequestMapping("/mq")
@Slf4j
public class RabbitMqController {

    @Autowired
    private OrderService orderService;
    @GetMapping("/initOrder")
    public List<UserAddress> getRabbitMq(@RequestParam("id") String id) throws Exception{
       return orderService.initOrder(String.valueOf(id));
    }
}

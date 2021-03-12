package com.fall.redis.mq.rabbit.consumer;

import com.fall.redis.mq.rabbit.bean.UserAddress;

import java.util.List;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/12
 * @time 12:48
 * @description
 */
public interface OrderService {

    List<UserAddress> initOrder(String id);
}

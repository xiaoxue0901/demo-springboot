package com.fall.redis.mq.rabbit.consumer;

import com.fall.redis.mq.rabbit.bean.UserAddress;
import com.fall.redis.mq.rabbit.produce.UserServiceImpl;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resources;
import java.util.List;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/12
 * @time 12:50
 * @description
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    UserServiceImpl userService;
    @Override
    public List<UserAddress> initOrder(String id) {
        log.info("请求报文, id: {}", id);
        List<UserAddress> list = userService.getAddress(id);
        for (UserAddress userAddress: list) {
            System.out.println(userAddress.getUserAddress());
        }
        return list;
    }
}

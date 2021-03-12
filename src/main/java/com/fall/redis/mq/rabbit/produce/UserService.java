package com.fall.redis.mq.rabbit.produce;

import com.fall.redis.mq.rabbit.bean.UserAddress;

import java.util.List;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/11
 * @time 15:46
 * @description
 */
public interface UserService {

    List<UserAddress> getAddress(String userId);
}

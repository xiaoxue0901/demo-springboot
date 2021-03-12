package com.fall.redis.mq.rabbit.produce;

import com.fall.redis.mq.rabbit.bean.UserAddress;
import com.fall.redis.mq.rabbit.produce.Producer;
import com.fall.redis.mq.rabbit.produce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/12
 * @time 11:48
 * @description
 */
@Service("userServiceMq")
public class UserServiceImpl implements UserService {
    @Autowired
    private Producer producer;

    @Override
    public List<UserAddress> getAddress(String userId) {
        // 向mq发送消息
        producer.sendMsg();
        UserAddress userAddress1 = new UserAddress(1, "1", "1");
        UserAddress userAddress2 = new UserAddress(2, "2", "2");
        return Arrays.asList(userAddress1, userAddress2);
    }
}

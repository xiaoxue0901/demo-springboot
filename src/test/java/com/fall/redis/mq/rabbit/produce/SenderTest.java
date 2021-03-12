package com.fall.redis.mq.rabbit.produce;

import com.fall.App;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/12
 * @time 15:47
 * @description
 */
@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
class SenderTest {

    @Resource
    private Sender sender;

    @Test
    void send() throws InterruptedException {
        sender.send();
        Thread.sleep(10000);
    }
}
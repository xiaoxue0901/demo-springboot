package com.fall.redis.mq.rabbit.produce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/17
 * @time 9:51
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ExchangeProducerTest {

    @Autowired
    private ExchangeProducer producer;

    @Test
    public void send() throws InterruptedException {
        producer.send();
        Thread.sleep(10000);
    }
}
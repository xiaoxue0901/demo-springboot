package com.fall.redis.mq.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author xql132@zcsmart.com
 * @date 2021/3/12
 * @time 15:43
 * @description
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue firstQueue() {
        return new Queue("enjoy");
    }

    /**
     * 注入交换机
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("DIRECT_EXCHANGE");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("TOPIC_EXCHANGE");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("FANOUT_EXCHANGE");
    }

    /**
     * 注入队列
     *
     * @return
     */
    @Bean
    public Queue secondQueue() {
        return new Queue("fall.direct");
    }

    @Bean
    public Queue thirdQueue() {
        return new Queue("fall.beauty");
    }

    @Bean
    public Queue fourQueue() {
        return new Queue("fanout1");
    }

    @Bean
    public Queue fiveQueue() {
        return new Queue("fanout2");
    }

    /**
     * 定义交换机和队列的绑定关系
     * @return
     */
    @Bean
    public Binding bindDirect() {
        return BindingBuilder.bind(secondQueue()).to(directExchange()).with("fall.direct");
    }

    @Bean
    public Binding bindTopic() {
        return BindingBuilder.bind(thirdQueue()).to(topicExchange()).with("fall.*");
    }

    @Bean
    public Binding bindTopic2() {
        return BindingBuilder.bind(secondQueue()).to(topicExchange()).with("fall.*");
    }

    @Bean
    public Binding bindFanout1() {
        return BindingBuilder.bind(fourQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding bindFanout2() {
        return BindingBuilder.bind(fiveQueue()).to(fanoutExchange());
    }

}

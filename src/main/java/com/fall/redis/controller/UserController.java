package com.fall.redis.controller;

import com.fall.redis.bean.User;
import com.fall.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author xql132@zcsmart.com
 * @date 2021/2/23
 * @time 16:31
 * @description
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public void test() {
        redisCacheTemplate.opsForValue().set("test_user_key", new User(1, "张三", 23));
        User user = (User) redisCacheTemplate.opsForValue().get("test_user_key");
        log.info("获取对象:{}", user.toString());
    }

    @RequestMapping("/add")
    public void add() {
        User user = userService.save(new User(4, "离线", 30));
        log.info("添加的用户信息:{}", user.toString());
    }

    @RequestMapping("/delete")
    public void delete() {
        userService.delete(4);

    }

    @RequestMapping("/get/{id}")
    public void get(@PathVariable("id") String idStr) throws Exception {
        if (StringUtils.isBlank(idStr)) {
            throw new Exception("id为空");
        }
        Integer id = Integer.valueOf(idStr);
        User user = userService.get(id);
        log.info("获取用户的信息:{}", user.toString());

    }



}

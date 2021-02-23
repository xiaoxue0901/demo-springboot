package com.fall.redis.service;

import com.fall.redis.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xql132@zcsmart.com
 * @date 2021/2/23
 * @time 17:43
 * @description
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private static Map<Integer,User> userMap =new HashMap<>();

    static {
        userMap.put(1, new User(1, "肖战", 25));
        userMap.put(2, new User(1, "王一博", 23));
        userMap.put(3, new User(1, "杨紫", 30));
    }
    @CachePut(value = "user", key = "#user.id")
    @Override
    public User save(User user) {
        userMap.put(user.getId(), user);
        log.info("进入save方法, 当前存储对象:{}", user.toString());
        return user;
    }

    @CacheEvict(value = "user", key = "#id")
    @Override
    public void delete(int id) {
        userMap.remove(id);
        log.info("进入delete方法, 删除成功");
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public User get(Integer id) {
        log.info("进入get方法, 当前获取对象:{}", userMap.get(id) == null? null:userMap.get(id).toString());
        return userMap.get(id);
    }
}

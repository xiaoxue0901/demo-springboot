package com.fall.redis.service;

import com.fall.redis.bean.User;

/**
 * @author xql132@zcsmart.com
 * @date 2021/2/23
 * @time 17:42
 * @description
 */
public interface UserService {
    User save(User user);

    void delete(int id);

    User get(Integer id);
}

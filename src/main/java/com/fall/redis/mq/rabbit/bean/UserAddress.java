package com.fall.redis.mq.rabbit.bean;

import lombok.Data;

/**
 * @author xql132@zcsmart.com
 * @date 2021/3/12
 * @time 11:46
 * @description
 */
@Data
public class UserAddress {
    private int id;
    private String userAddress;
    private String userId;

    public UserAddress() {
    }

    public UserAddress(int id, String userAddress, String userId) {
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
    }
}

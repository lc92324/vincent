package com.example.redis;

public interface KeyPrefix {

    //失效时间
     int expireSeconds();
    //获取前缀
     String getPrefix();

}

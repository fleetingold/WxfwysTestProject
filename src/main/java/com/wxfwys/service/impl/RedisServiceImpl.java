package com.wxfwys.service.impl;

import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClientConfig;

public class RedisServiceImpl {
    private Jedis jedis;

    public RedisServiceImpl() {
        this.jedis = new Jedis("106.15.89.240", 6379);
    }
}

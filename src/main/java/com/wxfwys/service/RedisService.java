package com.wxfwys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisService {
    void ping();

    void select(int index);

    boolean exists(String key);

    String type(String key);

    void del(String key);

    void rename(String oldKey, String newKey);

    void renamenx(String oldKey, String newKey);

    void move(String key, int dbIndex);

    byte[] dump(String key);

    Set<String> keys(String pattern);

    void set(String key, String value);

    String get(String key);

    void lpush(String key, String member);

    List<String> lrange(String key, long start, long stop);

    void hmset(String key, String field, String value);

    void hmset(String key, Map<String, String> hash);

    String hget(String key, String field);

    Map<String, String> hgetAll(String key);

    void sadd(String key, String member);

    Set<String> smembers(String key);

    void zadd(String key, double score, String member);

    Set<String> zrange(String key, long start, long stop);

    Set<String> zrangeByScore(String key, double min, double max);
}

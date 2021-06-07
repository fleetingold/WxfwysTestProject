package com.wxfwys.service.impl;

import com.wxfwys.service.RedisService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service(value = "redisService")
public class RedisServiceImpl implements RedisService {
    private Jedis jedis;

    public RedisServiceImpl() {
        this.jedis = new Jedis("106.15.89.240", 6379);
        this.jedis.auth("abc-123");
    }

    @Override
    public void ping() {
        if (jedis != null) {
            System.out.println("服务正在运行: " + jedis.ping());
        }
    }

    @Override
    public void select(int index) {
        jedis.select(index);
    }

    @Override
    public boolean exists(String key) {
        return jedis.exists(key);
    }

    @Override
    public String type(String key) {
        return jedis.type(key);
    }

    @Override
    public void del(String key) {
        jedis.del(key);
    }

    @Override
    public void rename(String oldKey, String newKey) {
        jedis.rename(oldKey, newKey);
    }

    @Override
    public void renamenx(String oldKey, String newKey) {
        jedis.renamenx(oldKey, newKey);
    }

    @Override
    public void move(String key, int dbIndex) {
        jedis.move(key, dbIndex);
    }

    @Override
    public byte[] dump(String key) {
        return jedis.dump(key);
    }

    @Override
    public Set<String> keys(String pattern) {
        return jedis.keys(pattern);
    }

    @Override
    public void set(String key, String value) {
        jedis.set(key, value);
    }

    @Override
    public String get(String key) {
        return jedis.get(key);
    }

    @Override
    public void lpush(String key, String member) {
        jedis.lpush(key, member);
    }

    @Override
    public List<String> lrange(String key, long start, long stop) {
        return jedis.lrange(key, start, stop);
    }

    @Override
    public void hmset(String key, String field, String value) {
        Map<String, String> hash = new HashMap<>();
        hash.put(field, value);
        hmset(key, hash);
    }

    @Override
    public void hmset(String key, Map<String, String> hash) {
        jedis.hmset(key, hash);
    }

    @Override
    public String hget(String key, String field) {
        return jedis.hget(key, field);
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        return jedis.hgetAll(key);
    }

    @Override
    public void sadd(String key, String member) {
        jedis.sadd(key, member);
    }

    @Override
    public Set<String> smembers(String key) {
        return jedis.smembers(key);
    }

    @Override
    public void zadd(String key, double score, String member) {
        jedis.zadd(key, score, member);
    }

    @Override
    public Set<String> zrange(String key, long start, long stop) {
        return jedis.zrange(key, start, stop);
    }

    @Override
    public Set<String> zrangeByScore(String key, double min, double max) {
        return jedis.zrangeByScore(key, min, max);
    }
}

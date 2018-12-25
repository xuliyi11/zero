package com.redis;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class ZeroRedis implements InitializingBean {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ValueOperations<String, String> redis;



    public void set(String key, String value) {
        redis.set(key, value);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        redis = redisTemplate.opsForValue();
    }
}

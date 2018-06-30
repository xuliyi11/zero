package com.redis;

import com.exception.MiddleWareException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by xly on 2018/4/21.
 */
public class ZeroRedis {
    private static final Logger logger = LoggerFactory.getLogger(ZeroRedis.class);

   @Autowired
   private JedisPool jedisPool ;

    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized  Jedis getJedis() {
        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            } else {
                logger.error("Exception: 连接Redis 服务器异常");
            }
        } catch (Exception e) {
            logger.error("Exception: 连接Redis 服务器异常");
            throw new MiddleWareException("Exception: 连接Redis 服务器异常");
        }
        return jedis;
    }

    /**
     * 释放jedis资源
     * @param jedis
     */
    public  void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     *获取redis锁
     * @param key
     * @param expireTime
     * @param value
     */
    public  void getLock(String key,Long expireTime,String value){
        Boolean.valueOf(getJedis().setnx(key,"").toString());
    }

    /**
     * 校验缓存中是否存在 key
     * @param redisKey
     * @return
     */
    public Boolean exists(String redisKey){
        return getJedis().exists(redisKey);
    }

    public String get(String key){
        return getJedis().get(key);
    }

    public String set(String key,String value){
        return getJedis().set(key,value);
    }
}

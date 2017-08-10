package com.scala.springboot.config

import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.{Bean, Configuration}
import redis.clients.jedis.{JedisPool, JedisPoolConfig}

/**
  * Created by admin on 2017/8/9.
  */
@Configuration
@EnableCaching
class RedisConfig {

  @Value("${spring.redis.host}")
  var host: String = _

  @Value("${spring.redis.port}")
  var port:Int = _

  @Value("${spring.redis.timeout}")
  var timeout:Int = _

  @Value("${spring.redis.pool.max-idle}")
  var maxIdle:Int = _

  @Value("${spring.redis.pool.max-wait}")
  var maxWaitMillis:Long = _

  @Bean
  def redisPoolFactory(): JedisPool ={
    Logger.getLogger(getClass).info("Jedis注入成功！")

    Logger.getLogger(getClass).info("redis地址：" + host + ":" + port)

    val jedisPoolConfig:JedisPoolConfig = new JedisPoolConfig()

    jedisPoolConfig setMaxIdle maxIdle

    jedisPoolConfig setMaxWaitMillis maxWaitMillis

    val jedisPool : JedisPool = new JedisPool(jedisPoolConfig,host,port,timeout)

    jedisPool
  }
}

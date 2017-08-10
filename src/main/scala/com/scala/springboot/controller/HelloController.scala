package com.scala.springboot.controller

import java.util.Date

import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.web.bind.annotation._
import redis.clients.jedis.JedisPool


/**
  * Created by admin on 2017/8/9.
  */
@RestController
class HelloController {

  @Autowired
  var jedisPool:JedisPool = _

  @RequestMapping(Array("/hello"))
  def greeting(@RequestParam(value = "name",defaultValue = "Admin") name:String) = {

    val now = new Date

    val content = "Hello, "+name+"! Now is: "+now

  }

  @RequestMapping(Array("/url"))
  def getUrl() = {

    val jedis= jedisPool.getResource

    val content = jedis get "url"

  }

}

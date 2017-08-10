package com.scala.springboot.service.Impl

import java.text.SimpleDateFormat
import java.util.Date

import com.alibaba.fastjson.{JSON, JSONObject}
import com.scala.springboot.service.ScheduleTaskService
import com.scala.springboot.util.BaiduapiOffline
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import redis.clients.jedis.{Jedis, JedisPool}

import scala.collection.immutable.{List, ListMap, Map}
import scala.io.{BufferedSource, Source}

/**
  * Created by admin on 2017/8/9.
  */
@Service("ScheduleTaskService")
class ScheduleTaskServiceImpl extends ScheduleTaskService {

  final val dataFormat : SimpleDateFormat = new SimpleDateFormat("HH:mm:ss")

  @Autowired
  var jedisPool: JedisPool = _

  @Scheduled(fixedRate = 20000)
  override def fixTimeExecution(): Unit = {

    System.out.println("每隔20秒执行一次 "+ dataFormat.format(new Date()))

    changeGps2Redis(jedisPool)

  }

  @Scheduled(cron = "0 50 11 ? * *")
  override def reportCurrentTime(): Unit = {

    System.out.println("在规定时间 "+ dataFormat.format(new Date()) +" 执行");

  }

  def changeGps2Redis(jedisPool: JedisPool): Unit ={

    val jedis = jedisPool.getResource

    var url:String = jedis.get("url")

    var last_get_time:String = jedis.get("last_get_time")

    if(last_get_time!=null){

      url = url+"last_get_time="+delStr(last_get_time)

    }

    val str = Source.fromURL(url,"UTF-8")

    val j1 = JSON.parseObject(str.mkString)

    val j2 = JSON.parseArray(j1.get("value").toString)

    last_get_time = j1.get("server_time").toString

    val iterator = j2.iterator()

    //保存到jedis里面的list
    var list = List[ListMap[String,String]]()

    //保存到list里面的元素
    var listMap = ListMap[String,String]()

    while (iterator.hasNext ==true){

      val json = JSON.parseObject(iterator.next().toString)

      val driverlat:Double = json.get("latitude").toString.toDouble

      val driverlng:Double = json.get("longitude").toString.toDouble

      listMap = listMap+("latitude"->BaiduapiOffline.transform(driverlat,driverlng).get("y").toString)

      listMap = listMap+("longitude"->BaiduapiOffline.transform(driverlat,driverlng).get("x").toString)

      listMap = listMap+("address"->json.get("address").toString)

      listMap = listMap+("device_id"->json.get("device_id").toString)

      listMap = listMap+("direction"->json.get("direction").toString)

      listMap = listMap+("gps_time"->json.get("gps_time").toString)

      listMap = listMap+("speed"->json.get("speed").toString)

      listMap = listMap+("zhuang_tai"->json.get("zhuang_tai").toString)

      list = list :+ listMap

    }

    jedis.set("data",list.toString())

    jedis.set("last_get_time",last_get_time)

}



  def delJSon(jSON: JSONObject): Unit ={

  }


  def delStr(str:String): String ={

    val dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    val dateFormat2 = new SimpleDateFormat("yyyy-MM-dd%20HH:mm:ss")

    var date:Date = null

    date = dateFormat1.parse(str)

    dateFormat2.format(date)

  }


}

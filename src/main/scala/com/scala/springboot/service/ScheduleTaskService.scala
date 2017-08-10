package com.scala.springboot.service

/**
  * Created by admin on 2017/8/9.
  */
trait ScheduleTaskService {
  def reportCurrentTime(): Unit
  def fixTimeExecution(): Unit
}

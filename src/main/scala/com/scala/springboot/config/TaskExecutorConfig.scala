package com.scala.springboot.config

import java.util.concurrent.Executor

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.scheduling.annotation.{AsyncConfigurer, EnableAsync}
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

/**
  * Created by admin on 2017/8/10.
  */
@Configuration
@EnableAsync
class TaskExecutorConfig extends AsyncConfigurer{
  override def getAsyncExecutor: Executor = {
    val taskExecutor: ThreadPoolTaskExecutor = new ThreadPoolTaskExecutor

    taskExecutor.setMaxPoolSize(10)

    taskExecutor.setCorePoolSize(5)

    taskExecutor.setQueueCapacity(25)

    taskExecutor.initialize

    taskExecutor
  }

  override def getAsyncUncaughtExceptionHandler: AsyncUncaughtExceptionHandler = ???
}

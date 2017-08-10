package com.scala.springboot.config

import com.alibaba.druid.support.http.{StatViewServlet, WebStatFilter}
import org.springframework.boot.web.servlet.{FilterRegistrationBean, ServletRegistrationBean}
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * Created by admin on 2017/8/10.
  */
@Configuration
class DruidConfig {
  @Bean def druidServlet: ServletRegistrationBean = {
    val servletRegistrationBean: ServletRegistrationBean = new ServletRegistrationBean(new StatViewServlet, "/druid/*")
    servletRegistrationBean.addInitParameter("loginUsername", "admin")
    servletRegistrationBean.addInitParameter("loginPassword", "123456")
    servletRegistrationBean
  }

  @Bean def filterRegistrationBean: FilterRegistrationBean = {
    val filterRegistrationBean: FilterRegistrationBean = new FilterRegistrationBean
    filterRegistrationBean.setFilter(new WebStatFilter)
    filterRegistrationBean.addUrlPatterns("/*")
    filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*")
    filterRegistrationBean
  }
}

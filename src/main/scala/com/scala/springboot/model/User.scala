package com.scala.springboot.model

import java.io.Serializable
import javax.persistence.{GeneratedValue, GenerationType, Id}

/**
  * Created by admin on 2017/8/10.
  */
class User extends Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) private var id: Integer = null
  private var username: String = null
  private var password: String = null
  private var enable: Integer = null

  def getId: Integer = {
    return id
  }

  def setId(id: Integer) {
    this.id = id
  }

  def getUsername: String = {
    return username
  }

  def setUsername(username: String) {
    this.username = username
  }

  def getPassword: String = {
    return password
  }

  def setPassword(password: String) {
    this.password = password
  }

  def getEnable: Integer = {
    return enable
  }

  def setEnable(enable: Integer) {
    this.enable = enable
  }
}

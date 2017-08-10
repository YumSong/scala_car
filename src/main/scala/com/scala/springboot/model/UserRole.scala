package com.scala.springboot.model

import javax.persistence.{Column, Table}

/**
  * Created by admin on 2017/8/10.
  */
@Table(name = "user_role")
class UserRole {
  @Column(name = "userId") private var userid: Integer = null
  @Column(name = "roleId") private var roleid: Integer = null

  def getUserid: Integer = {
    return userid
  }

  def setUserid(userid: Integer) {
    this.userid = userid
  }

  def getRoleid: Integer = {
    return roleid
  }

  def setRoleid(roleid: Integer) {
    this.roleid = roleid
  }
}

package com.scala.springboot.model

import javax.persistence.{Column, Id, Table}

/**
  * Created by admin on 2017/8/10.
  */
@Table(name = "role_resources")
class RoleResource {
  @Id
  @Column(name = "roleId") private var roleid: Integer = null
  @Id
  @Column(name = "resourcesId") private var resourcesid: Integer = null

  def getRoleid: Integer = {
    return roleid
  }

  def setRoleid(roleid: Integer) {
    this.roleid = roleid
  }

  def getResourcesid: Integer = {
    return resourcesid
  }

  def setResourcesid(resourcesid: Integer) {
    this.resourcesid = resourcesid
  }
}

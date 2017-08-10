package com.scala.springboot.model

import javax.persistence.{Column, GeneratedValue, GenerationType, Id}

/**
  * Created by admin on 2017/8/10.
  */
class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) private var id: Integer = null
  @Column(name = "roleDesc") private var roledesc: String = null

  def getId: Integer = {
    return id
  }

  def setId(id: Integer) {
    this.id = id
  }

  def getRoledesc: String = {
    return roledesc
  }

  def setRoledesc(roledesc: String) {
    this.roledesc = roledesc
  }
}

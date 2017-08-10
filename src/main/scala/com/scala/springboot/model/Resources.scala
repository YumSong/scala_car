package com.scala.springboot.model

import javax.persistence.{Column, GeneratedValue, GenerationType, Id}

/**
  * Created by admin on 2017/8/10.
  */
class Resources {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) private var id: Integer = null
  private var name: String = null
  @Column(name = "resUrl") private var resurl: String = null
  private var `type`: Integer = null
  @Column(name = "parentId") private var parentid: Integer = null
  private var sort: Integer = null

  def getId: Integer = {
    return id
  }

  def setId(id: Integer) {
    this.id = id
  }

  def getName: String = {
    return name
  }

  def setName(name: String) {
    this.name = name
  }

  def getResurl: String = {
    return resurl
  }

  def setResurl(resurl: String) {
    this.resurl = resurl
  }

  def getType: Integer = {
    return `type`
  }

  def setType(`type`: Integer) {
    this.`type` = `type`
  }

  def getParentid: Integer = {
    return parentid
  }

  def setParentid(parentid: Integer) {
    this.parentid = parentid
  }

  def getSort: Integer = {
    return sort
  }

  def setSort(sort: Integer) {
    this.sort = sort
  }
}

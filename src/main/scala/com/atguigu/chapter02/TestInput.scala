package com.atguigu.chapter02

import scala.io.StdIn

object TestInput {

  def main(args: Array[String]): Unit = {

    println("输入姓名：")
    var name: String = StdIn.readLine()

    println("输入年龄：")
    var age: Int = StdIn.readShort()

    println("输入薪水：")
    var salary: Double = StdIn.readDouble()

    println(name)
    println(age)
    println(salary)

  }

}

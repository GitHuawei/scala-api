package com.atguigu.chapter04

import scala.io.StdIn

/**
 * 4.1  分支控制if-else
 */
object TestIfElse {

  def main(args: Array[String]): Unit = {

    println("输入年龄：")
    var age1: Int = StdIn.readShort()

    if (age1 < 18) {
      println("童年")
    } else if (age1 < 40) {
      println("成年")
    } else if (age1 < 60) {
      println("中老年")
    } else {
      println("老年")
    }

    // Scala中if-else表达式其实是有返回值的，具体返回值取决于满足条件的代码体的最后一行内容
    println("再次输入年龄：")
    var age2: Short = StdIn.readShort()

    var res: String = if (age2 < 18) {
      "童年"
    } else if (age2 < 40) {
      "成年"
    } else if (age2 < 60) {
      "中老年"
    } else {
      "老年"
    }

    println(res)

    // Scala中返回值类型不一致，取它们共同的祖先类型
    println("再次输入年龄：")
    var age3: Short = StdIn.readShort()
    var result: Any = if (age3 < 18) {
      "童年"
    } else if (age3 < 40) {
      "成年"
    } else if (age3 < 60) {
      "中老年"
    } else {
      100
    }

    println(result)

    // 三元运算符可以用if else实现
    println("再次输入年龄：")
    var age4 = StdIn.readInt()

    var result1: String = if (age4 < 20) "年少" else "年长"
    println(result1)
  }

}

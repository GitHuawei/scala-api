package com.atguigu.chapter03

/**
 * 3.3  逻辑运算符
 */
object TestLogic {

  def main(args: Array[String]): Unit = {

    // 测试：&&、||、!
    var a = true
    var b = false

    println("a&&b=" + (a && b)) // a&&b=false
    println("a||b=" + (a || b)) // a||b=true
    println("!(a&&b)=" + (!(a && b))) // !(a&&b)=true

  }
}

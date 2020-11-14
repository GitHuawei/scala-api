package com.atguigu.chapter03

/**
 * 3.1  算术运算符
 */
object TestArithmetic {

  def main(args: Array[String]): Unit = {

    var r1: Int = 10 / 3 // 3
    println("r1=" + r1)

    var r2: Double = 10 / 3 // 3.0
    println("r2=" + r2)

    var r3: Double = 10.0 / 3 // 3.3333333333333335
    println("r3=" + r3)

    println("r3=" + r3.formatted("%.2f")) // 保留两位小数，四舍五入

    var r4 = 10 % 3 // 1
    println("r4=" + r4)

  }

}

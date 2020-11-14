package com.atguigu.chapter02

/**
 * 强制类型转换
 * 将精度大的数值类型转换为精度小的数值类型。使用时要加上强制转函数，但可能造成精度降低或溢出，格外要注意。
 */
object TestForceTransfer {

  def main(args: Array[String]): Unit = {

    // 将数据由高精度转换为低精度，需要使用强制类型转换
    var n1: Int = 2.5.toInt // n1 = 2
    println("n1=" + n1)

    var r1: Int = 10 * 3.5.toInt + 6 * 1.5.toInt // r1 = 36

    var r2: Int = (10 * 3.5 + 6 * 1.5).toInt // 44

    println("r1=" + r1 + "r2=" + r2)

  }
}

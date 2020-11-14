package com.atguigu.chapter04

import scala.util.control.Breaks._

object TestBreaks {
  def main(args: Array[String]): Unit = {

    // 需求3：对break进行省略
    breakable {
      for (i <- 1 to 10) {
        println("需求三：" + i)
        if (i == 5) break
      }
    }

    println("正常结束循环")

    // 需求4：循环遍历10以内的所有数据，奇数打印，偶数跳过（continue）
    for (i <- 1 to 10) {
      if (i % 2 == 1) {
        println(i)
      } else {
      }
    }
  }
}

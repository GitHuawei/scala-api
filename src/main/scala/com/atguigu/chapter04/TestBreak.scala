package com.atguigu.chapter04

import scala.util.control.Breaks

/**
 * 4.4  循环中断
 * <p>
 * Scala内置控制结构特地去掉了break和continue，是为了更好的适应函数式编程，推荐使用函数式的风格解决
 * break和continue的功能，而不是一个关键字。Scala中使用breakable控制结构来实现break和continue功能。
 */
object TestBreak {

  def main(args: Array[String]): Unit = {

    //  需求1：采用异常的方式退出循环
    try {
      for (i <- 1 to 10) {
        println("需求一：" + i)
        if (i == 3) throw new RuntimeException()
      }
    } catch {
      case e: Throwable =>
    }

    println("正常结束循环")

    println("-----------------------------------")

    //  需求2：采用Scala自带的函数，退出循环

    Breaks.breakable(for (i <- 1 to 10) {
      println("需求二：" + i)
      if (i == 4) Breaks.break()
    })

    println("正常结束循环")
  }

  // 需求3：对break进行省略。见 TestBreaks
}

package com.atguigu.chapter04

/**
 * 4.2  循环控制
 */
object TestFor {

  def main(args: Array[String]): Unit = {

    // 循环10次
    for (i <- 1 to 10) {
      println("宋宋，告别海狗人参丸吧! " + i)
    }

    println("----------------------------------------------")

    // 循环9次
    for (i <- 1 until 10) {
      println("宋宋，告别海狗人参丸吧! " + i)
    }

    println("----------------------------------------------")

    // 当i = 3时才输出
    for (i <- 1 to 10 if i == 3) {
      println("宋宋，告别海狗人参丸吧! " + i)
    }

    println("----------------------------------------------")

    // i 为奇数时输出
    for (i <- 1 to 10 by 2) {
      println("宋宋，告别海狗人参丸吧! " + i)
    }

    println("----------------------------------------------")

    // 嵌套循环
    for (i <- 1 to 3; j <- 1 to 3) {
      println("宋宋，告别海狗人参丸吧! i=" + i + ", j=" + j)
    }

    println("----------------------------------------------")

    // 引入变量
    for (i <- 1 to 3; j = 4 - i) {
      println("宋宋，告别海狗人参丸吧! i=" + i + ", j=" + j)
    }

    // 循环返回值。将遍历过程中处理的结果返回到一个新Vector集合中，使用yield关键字。
    var res = for (i <- 1 to 10) yield i
    println(res)

    var res2 = for (i <- 1 to 10) yield {
      i * 2
    }

    println(res2)

    // 倒序打印
    for (i <- 1 to 10 reverse) {
      println(i)
    }

  }

}

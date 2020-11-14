package com.atguigu.chapter05

/**
 * 惰性函数
 *
 * 说明：当函数返回值被声明为lazy时，函数的执行将被推迟，直到我们首次对此取值，该函数才会执行。这种函数我们
 * 称之为惰性函数
 */
object TestFunction14 {

  def main(args: Array[String]): Unit = {
    lazy val res = sum(1, 2)

    println("-------------------")
    println("res = " + res)

  }

  def sum(a: Int, b: Int): Int = {
    println("sum 函数被执行。。。。。。")
    return a + b
  }

}

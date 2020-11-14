package com.atguigu.chapter05

/**
 * 控制抽象：案例实操
 */
object TestFunction13 {

  def main(array: Array[String]): Unit = {

    //（1）传递代码块
    foo({
      println("aaaaaaaaaaaaaaaaaaaa")
    })

    println("-------------------------")

    //（2）小括号可以省略
    foo {
      println("aaa")
    }

    println("------------------------")

    // 测试自定义while循环
    var i: Int = 1
    myWhile(i <= 10) {
      println(i)
      i += 1
    }


  }

  def foo(a: => Unit): Unit = {
    println(a)
    println(a)
  }


  /**
   * 自定义while循环
   *
   * @param condition
   * @param op
   */
  def myWhile(condition: => Boolean)(op: => Unit): Unit = {
    if (condition) {
      op
      myWhile(condition)(op)
    }
  }
}

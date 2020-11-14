package com.atguigu.chapter05

/**
 * 控制抽象
 *
 * 注意：Java只有值调用；Scala既有值调用，又有名调用。
 */
object TestFunction12 {
  def main(args: Array[String]): Unit = {

    // 1）值调用：把计算后的值传递过去
    //先把3+4的值，计算后给a
    foo(3 + 4)
    println("-------------------------")

    // 2）名调用：把代码传递过去
    def f: () => Int = () => {
      println("f......")
      10
    }

    foolish(f())
  }

  def foo(a: Int): Unit = {
    println(a)
  }

  def foolish(a: => Int): Unit = {
    println(a)
    println(a)
  }
}

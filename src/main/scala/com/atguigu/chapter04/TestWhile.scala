package com.atguigu.chapter04

/**
 * 4.3  while循环
 * while语句没有返回值，即整个while语句的结果是Unit类型()
 *
 * 因为while中没有返回值，所以当要用该语句来计算并返回结果时，就不可避免的使用变量，
 * 而变量需要声明在while循环的外部，那么就等同于循环的内部对外部的变量造成了影响，
 * 也就违背了函数式编程的重要思想（输入=>函数=>输出，不对外界造成影响），
 * 所以不推荐使用，而是推荐使用for循环。
 */
object TestWhile {

  def main(args: Array[String]): Unit = {
    var i: Int = 0
    while (i < 10) {
      println("宋宋，喜欢海狗人参丸！" + i)
      i += 1
    }
  }
}

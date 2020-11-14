package com.atguigu.chapter03

/**
 * 3.6  Scala运算符本质：
 * 在 Scala中其实是没有运算符的，所有得到运算符都是方法
 * 1)当调用对象的方法时，点.可以省略
 * 2)如果函数参数只有一个，或者没有参数，()可以省略
 */
object TestOpt {

  def main(args: Array[String]): Unit = {
    //标准的加法运算
    var i: Int = 1.+(2)

    // 当调用对象的方法时，.可以省略
    var j: Int = 1 + (2)

    // 如果函数的参数只有一个，或者没有参数，()可以省略
    var k: Int = 1 + 2

    println(1.toString())
    println(1 toString())
    println(1 toString)


  }

}

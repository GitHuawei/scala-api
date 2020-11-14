package com.atguigu.chapter05

/**
 * 函数至简原则
 */
object TestFunction05 {

  def main(args: Array[String]): Unit = {

    // 1、函数标准写法
    def func(s: String): String = {
      return s + "金莲"
    }

    println(func("123"))

    //  至简原则：能省则省

    //1、return 可以省略，scala会使用函数体的最后一行代码作为返回值
    def func01(s: String): String = {
      s + "金莲"
      s + "武松"
    }

    println(func01("456"))

    //2、如果函数体只有一行代码，可以省略花括号
    def func02(s: String): String = s + "金莲"

    //3、返回值类型如果能够推断出来，那么可以省略（: 和返回值类型一起省略）
    def func03(s: String) = s + "金莲"

    println(func03("hello3"))

    //4、如果有return，则不能省略返回值类型，必须指定。
    def func04(s: String): String = return s + "金莲"

    println(func04("hello4"))

    //5、如果函数明确声明unit，那么即使函数体中使用return关键字也不起作用
    def func05(): Unit = {
      return "金莲"
    }

    func05()

    //6、scala如果期望是无返回值类型，可以省略等号
    def func06() {
      "金莲"
    }

    println(func06())

    //7、如果函数无参，但是声明了参数列表，那么调用时，小括号，可加可不加
    def func07() = "金莲"

    println(func07())
    println(func07)

    //8、如果函数没有参数列表，那么小括号可以省略，调用时小括号必须省略
    def func08 = "金莲"

    println(func08)

    //9、如果不关心名称，只关心逻辑处理，那么函数名(def)可以省略
    def func09 = (x: String) => {
      println("武松")
    }

    def func10(f: String => Unit) = {
      f("")
    }

    func10(func09)

    println(func10((x: String) => {
      println("wusong")
    }))

  }

}

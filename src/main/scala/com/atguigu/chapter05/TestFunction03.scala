package com.atguigu.chapter05

/**
 * 函数定义
 * （1）函数1：无参，无返回值
 * （2）函数2：无参，有返回值
 * （3）函数3：有参，无返回值
 * （4）函数4：有参，有返回值
 * （5）函数5：多参，无返回值
 */
object TestFunction03 {

  def main(args: Array[String]): Unit = {
    // 函数1：无参，无返回值
    def test1(): Unit = {
      println("无参，无返回值")
    }

    test1()

    // 函数2：无参，有返回值
    def test2(): String = {
      "无参，有返回值"
    }

    println(test2())

    // 函数3：有参，无返回值
    def test3(params: String): Unit = {
      println(params)
    }

    test3("金莲")

    // 函数4：有参，有返回值
    def test4(params: String): String = {
      params + " 有参，有返回值"
    }

    println(test4("123"))

    // 函数5：多参，无返回值
    def test5(name: String, age: Int): Unit = {
      println(s"$name, $age")
    }

    test5("zhangsan", 15)
  }

}

package com.atguigu.chapter05

/**
 * 函数参数
 * 1）案例实操
 * （1）可变参数
 * （2）如果参数列表中存在多个参数，那么可变参数一般放置在最后
 * （3）参数默认值，一般将有默认值的参数放置在参数列表的后面
 * （4）带名参数
 */
object TestFunction04 {
  def main(args: Array[String]): Unit = {

    // （1）可变参数
    def test(s: String*): Unit = {
      println(s)
    }

    // 输入参数时，输出WrappedArray(hello, scala)
    test("hello", "scala")

    // 未输入参数时，输出List()
    test()

    // (2)如果参数列表中存在多个参数，那么可变参数一般放置在最后
    def test2(name: String, s: String*): Unit = {
      println(name + ", " + s)
    }

    test2("金莲", "猪八戒", "孙悟空") // 金莲, WrappedArray(猪八戒, 孙悟空)

    // (3)参数默认值
    def test3(name: String, age: Int = 30): Unit = {
      println(s"$name, $age")
    }

    test3("大郎")

    def test4(sex: String = "男", name: String): Unit = {
      println(s"$name, $sex")
    }
    // Scala函数中函数传递是：从左到右
    // 一般情况下， 将有默认值的参数放置在参数列表的后面
    // test4("武松")

    // 带名参数
    test4(name = "西门庆")
  }
}

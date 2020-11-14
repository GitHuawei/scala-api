package com.atguigu.chapter05

object TestFunction01 {

  def main(args: Array[String]): Unit = {

    // （1）函数定义
    def f(params: String): Unit = {
      print(params)
    }

    // （2）函数调用
    f("hello world")

  }

}

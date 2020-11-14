package com.atguigu.chapter05


/**
 * 函数和方法的区别
 *
 * （1）为完成某一功能的程序语句的集合，称为函数。
 * （2）类中的函数称之方法。
 */
object TestFunction02 {

  def main(args: Array[String]): Unit = {

    // （1）Scala语言可以在任何的语法结构中声明任何的语法
    import java.util.Date
    new Date();

    // (2)函数没有重载和重写的概念，程序报错

    def test(): Unit = {
      println("无参，有返回值")
    }

    test()

//    def test(params: String): Unit = {
//
//    }

    //（3）Scala中函数可以嵌套定义
    def test2(): Unit = {
      def test3(): Unit = {
        println("函数可以嵌套定义")
      }
    }


  }

  // (2)方法可以进行重载和重写，程序可以执行
  def main(): Unit = {

  }

}

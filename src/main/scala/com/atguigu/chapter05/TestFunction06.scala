package com.atguigu.chapter05

/**
 * 5.2.1 高阶函数
 */
object TestFunction06 {

  def main(args: Array[String]): Unit = {

    // 1、函数可以作为值传递
    var f = foo()
    println(f)


    //2、在被调用函数后面加上 _，相当于把函数foo当成一个整体，传递给变量f1
    var f1 = foo _
    f1()
    println(f1)
    println("----------")
    foo()


    //3、函数可以作为参数进行传递

    // 定义一个函数，函数参数还是一个函数签名；f表示函数名称;(Int,Int)表示输入两个Int参数；Int表示函数返回值
    def f2(f: (Int, Int) => Int): Int = {
      f(2, 3)
    }

    // 定义一个函数，参数和返回值类型和f1的输入参数一致
    def add(a: Int, b: Int): Int = a + b

    // 将add函数作为参数传递给f1函数，如果能够推断出来不是调用，_可以省略
    println(f2(add))
    println(f2(add _))


    //4、函数可以作为函数返回值返回
    def f3(): () => Unit = {
      def f4(): Unit = {

      }

      f4 _
    }

    var f5 = f3()
    // 因为f3函数的返回值依然为函数，所以变量f可以作为函数继续调用
    f5()
    //上面的代码可以简化为
    f3()()


  }


  def foo(): Unit = {
    println("foo....")
  }
}

package com.atguigu.chapter05

/**
 * 匿名函数
 */
object TestFunction07 {
  def main(args: Array[String]): Unit = {

    // （1）定义一个函数：参数包含数据和逻辑函数
    def operation(array: Array[Int], op: Int => Unit): Unit = {
      for (elem <- array) {
        op(elem)
      }
    }

    //（2）定义逻辑函数
    def op(elem: Int): Unit = {
      println(elem * elem)
    }

    //（3）标准函数调用
    operation(Array(1, 2, 3, 4, 5), op)

    println("-----------------------")

    //（4）采用匿名函数
    operation(Array(1, 2, 3, 4), (ele: Int) => {
      println(ele + 1)
    })

    println("-----------------------")

    //（4.1）参数的类型可以省略，会根据形参进行自动的推导
    operation(Array(1, 2, 3, 4, 5, 6), (ele) => {
      println(ele + 1)
    })

    println("-----------------------")

    // （4.2）类型省略之后，发现只有一个参数，则圆括号可以省略；其他情况：没有参数和参数超过1个的永远不能省略圆括号
    operation(Array(1, 2, 3, 4, 5, 6), ele => {
      println(ele + 1)
    })

    println("----------------------")

    // （4.3）匿名函数如果只有一行，则大括号也可以省略
    operation(Array(1, 2, 3, 4, 5), ele => println(ele + 4))

    println("----------------------")

    // （4.4）如果参数只出现过一次，则参数省略且和面参数可以使用 _ 代替
    operation(Array(1, 2, 3, 4, 5), _ * 2)

  }
}

package com.atguigu.chapter02

/**
 * Unit类型、Null类型和Nothing类型
 *
 * 1、Unit
 * <p>表示无值，和Java中的void等同。用作不返回任何结果的方法的结果类型。Unit只有一个实例值，写成()。
 *
 * 2、Null
 * null , Null 类型只有一个实例值null
 *
 * 3、Nothing
 * <p>Nothing类型在Scala的类层级最低端；它是任何其他类型的子类型。
 * <p>当一个函数，我们确定没有正常的返回值，可以用Nothing来指定返回类型，这样有一个好处，就是我们可以把返回
 * <p>的值（异常）赋给其它的函数或者变量（兼容性）
 */
object TestSpecialType {

  def main(args: Array[String]): Unit = {
    def sayHello(): Unit = {
      println("hello")
    }

    sayHello()

    //null可以赋值给任意引用类型（AnyRef），但是不能赋值给值类型（AnyVal）

    var cat = new Cat()
    cat = null

    //    var n1: Int = null // 错误

    //    println("n1：" + n1)


    /*  Nothing，可以作为没有正常返回值的方法的返回类型，非常直观的告诉你这个方法不会正常返回，
     * 而且由于Nothing是其他任意类型的子类，他还能跟要求返回值的方法兼容。
     */
    def testNothing(): Nothing = {
      throw new Exception()
    }

  }
}

class Cat {

}

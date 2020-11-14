package com.atguigu.chapter01

/**
 * class 和 object 说明
 *
 * Scala完全面向对象，所以Scala去掉了Java非面向对象的元素，如static关键字，void类型
 *
 * 1、static
 *    Scala中无static关键字，由object实现类似静态方法的功能(类名.方法名)
 *    class 关键字和Java中的class关键字作用相同，用来定义一个类
 *
 * 2、void
 *    对于无返回值的函数，Scala定义其返回值为Unit类
 */
object HelloWorld {

  def main(args: Array[String]): Unit = {
    println("hello scala")
    System.out.println("hello scala!!!")
  }

}

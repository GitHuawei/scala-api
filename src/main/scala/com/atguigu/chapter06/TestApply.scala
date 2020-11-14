package com.atguigu.chapter06

/**
 * 6.6.2 apply方法
 * 1）说明
 * （1）通过伴生对象的apply方法，实现不使用new方法创建对象。
 * （2）如果想让主构造器变成私有的，可以在()之前加上private。
 * （3）apply方法可以重载。
 * （4）Scala中obj(arg)的语句实际是在调用该对象的apply方法，即obj.apply(arg)。用以同一面向对象编程和函数式编程的风格。
 * （5）当使用new关键字构建对象时，调用的其实时类的构造方法，当直接使用类名构建对象时，调用的其实时伴生对象的apply方法。
 * 2）案例实操
 */
object TestApply {

  def main(args: Array[String]): Unit = {

    // 通过伴生对象的apply方法，实现不使用new关键字创建对象
    val p1 = Person16()
    println("p1.name = " + p1.name)

    val p2 = Person16("张三");
    println("p1.name = " + p2.name)

  }

}

// 如果想让主构造器变成私有的，可以在()之前加上private
class Person16 private(cName: String) {

  var name: String = cName

}

object Person16 {
  def apply(): Person16 = {
    print("apply无参被调用。。。")
    new Person16("xxx")
  }

  def apply(name: String): Person16 = {
    println("apply有参被调用。。。")
    new Person16(name)
  }
}

package com.atguigu.chapter06

/**
 * 6.8 扩展
 * 6.8.1 类型检查和转换
 *  1）说明
 *  （1）obj.isInstanceOf[T]：判断obj是不是T类型。
 *  （2）obj.asInstanceOf[T]：将obj强转成T类型。
 *  （3）classOf获取对象的类名。
 *  2）案例实操：见Person20
 *
 * 6.8.2 枚举类和应用类
 *  1）说明
 *    枚举类：需要继承Enumeration
 *    应用类：需要继承App
 *  2）案例实操：见TestEnumerationAndApp
 *
 * 6.8.3 Type定义新类型
 *  1）说明
 *    使用type关键字可以定义新的数据数据类型名称，本质上就是类型的一个别名
 *  2）案例实操
 */
object TestCheckAndConvert {

}

class Person20 {

}

object Person20 {
  def main(args: Array[String]): Unit = {
    val person = new Person20

    //判断对象是否为某个类型的实例
    val boolean: Boolean = person.isInstanceOf[Person20]

    println(boolean)

    if (boolean) {
      val person1: Person20 = person.asInstanceOf[Person20]
      println(person1)
    }

    val pClass: Class[Person20] = classOf[Person20]
    println(pClass)
  }
}

object TestEnumerationAndApp {
  def main(args: Array[String]): Unit = {
    println(ColorEnum.RED)
  }
}

object ColorEnum extends Enumeration {
  var RED = Value(1, "red")
  var YELLOW = Value(2, "yellow")
  var BLUE = Value(3, "blue")
}

object TestApp extends App {
  println("xxxxxxxxxxxxxxxxxxxxxx")
}

object TestNewType {
  def main(args: Array[String]): Unit = {
    type S = String
    val v: S = "abc"

    def test(): S = "xyz"
  }
}

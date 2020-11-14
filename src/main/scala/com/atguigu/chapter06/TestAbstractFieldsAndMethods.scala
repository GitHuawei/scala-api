package com.atguigu.chapter06

/**
 * 6.5 抽象属性和抽象方法
 *
 * 6.5.1 抽象属性和抽象方法
 *  1）基本语法
 *  （1）定义抽象类：abstract class Person{} //通过abstract关键字标记抽象类
 *  （2）定义抽象属性：val|var name:String //一个属性没有初始化，就是抽象属性
 *  （3）定义抽象方法：def hello():String //只声明而没有实现的方法，就是抽象方法
 *  案例实操：见Person12
 *
 *  2）继承&重写
 *  （1）如果父类为抽象类，那么子类需要将抽象的属性和方法实现，否则子类也需声明为抽象类
 *  （2）重写非抽象方法需要用override修饰，重写抽象方法则可以不加override。
 *  （3）子类中调用父类的方法使用super关键字
 *  （4）属性重写只支持val类型，而不支持var。
 *  （5）Scala中属性和方法都是动态绑定，而Java中只有方法为动态绑定。
 * 案例实操：见Person13
 *
 * 6.5.2 匿名子类
 *
 *  1）说明
 *    Java一样，可以通过包含带有定义或重写的代码块的方式创建一个匿名的子类。
 *  2）案例实操：见Person14
 *
 */
object TestAbstractFieldsAndMethods {

}

abstract class Person12 {
  var name: String

  def hello(): Unit
}

class Teacher12 extends Person12 {

  var name: String = "teacher"

  override def hello(): Unit = {
    println("hello teacher")
  }
}

class Person13 {
  val name: String = "person"

  def hello(): Unit = {
    println("hello person")
  }
}

class Teacher13 extends Person13 {
  override val name: String = "teacher"

  override def hello(): Unit = {
    println("hello teacher")
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val teacher: Teacher13 = new Teacher13()
    println(teacher.name)
    teacher.hello()

    val teacher1: Person13 = new Teacher13()
    println(teacher1.name)
    teacher1.hello()
  }
}

abstract class Person14 {
  val name: String

  def hello(): Unit
}

object TestPerson14 {
  def main(args: Array[String]): Unit = {
    val person = new Person14 {
      override val name: String = "teacher"

      override def hello(): Unit = {
        println("hello teacher")
      }
    }

    println(person.name)
    person.hello()
  }
}
package com.atguigu.chapter06

/**
 * 6.7 特质（Trait）
 *    Scala语言中，采用特质trait（特征）来代替接口的概念，也就是说，多个类具有相同的
 * 特征（特征）时，就可以将这个特质（特征）独立出来，采用关键字trait声明。
 *    Scala中的trait中即可以有抽象属性和方法，也可以有具体的属性和方法，一个类可以
 * 混入（mixin）多个特质。类似于Java中的抽象类。
 *    Scala引入trait特征，第一可以替代Java的接口，第二个也是对单继承机制的一种补充。
 *
 * 6.7.1 特质声明
 *  1）基本语法
 *    trait 特质名 {
 *      trait体
 *    }
 *  2）案例实操：见PersonTrait
 *
 * 6.7.2 特质基本语法
 *    一个类具有某种特质（特征），就意味着这个类满足了这个特质（特征）的所有要素，所以在
 * 使用时，也采用了extends关键字，如果有多个特质或存在父类，那么需要采用with关键字连接。
 *
 *  1）基本语法：
 *    没有父类：class  类名 extends  特质1   with    特质2   with   特质3 …
 *    有父类：class  类名  extends  父类   with  特质1   with   特质2  with 特质3…
 *  2）说明
 *    （1）类和特质的关系：使用继承的关系。
 *    （2）当一个类去继承特质时，第一个连接词是extends，后面是with。
 *    （3）如果一个类在继承特质和父类时，应当把父类写在extends后。
 *  3）案例实操
 *    （1）特质可以同时拥有抽象方法和具体方法
 *    （2）一个类可以混入（mixin）多个特质
 *    （3）所有的Java接口都可以当做Scala特质使用
 *    （4）动态混入：可灵活的扩展类的功能
 *      （4.1）动态混入：创建对象时混入trait，而无需使类混入该trait
 *      （4.2）如果混入的trait中有未实现的方法，则需要实现
 */
object TestTrait {

  def main(args: Array[String]): Unit = {
    val teacher = new Teacher14
    teacher.say()
    teacher.eat()

    // 动态混入：可灵活的扩展类的功能
    val teacher2 = new Teacher14 with SexTrait {
      override var sex: String = "男"
    }

    // 调用混入的trait属性
    println(teacher2.sex)
  }

}

trait PersonTrait {

  // 声明属性
  var name: String = _

  // 抽象属性
  var age: Int

  // 声明方法
  def eat(): Unit = {
    println("eat ...")
  }

  // 抽象方法
  def say(): Unit
}

trait SexTrait {

  // 抽象属性
  var sex: String
}

// 一个类可以实现/继承多个特质
// 所有的Java接口都可以当做Scala特质使用
class Teacher14 extends PersonTrait with java.io.Serializable {
  override var age: Int = _

  override def say(): Unit = {
    println("say...")
  }

}

package com.atguigu.chapter06

import scala.beans.BeanProperty

/**
 * 6.2 类和对象
 *
 * 类：可以看成一个模板
 * 对象：表示具体的事物
 *
 * 6.2.1 定义类
 *
 * 1）回顾：Java中的类
 *      如果类是public的，则必须和文件名一致。
 *      一般，一个.java有一个public类
 *      注意：Scala中没有public，一个.scala中可以写多个类。
 *
 * 1）基本语法
 *      [修饰符] class 类名 {
 *          类体
 *      }
 *  说明
 *  （1）Scala语法中，类并不声明为public，所有这些类都具有公有可见性（即默认就是public）
 *  （2）一个Scala源文件可以包含多个类
 *
 * 6.2.2 属性
 *
 * 属性是类的一个组成部分
 *  1）基本语法
 *    [修饰符] var|val 属性名称 [：类型] = 属性值
 *    注：Bean属性（@BeanProperty），可以自动生成规范的setXxx/getXxx方法
 *
 *
 * 6.2.3 方法
 *
 * 1）基本语法
 *    def 方法名(参数列表) [：返回值类型] = {
 *      方法体
 *    }
 *
 *
 * 6.2.4 创建对象
 *
 * 1）基本语法
 *    val | var 对象名 [：类型]  = new 类型()
 *
 * 2）说明
 * （1）val修饰对象，不能改变对象的引用（即：内存地址），可以改变对象属性的值。
 * （2）var修饰对象，可以修改对象的引用和修改对象的属性值
 *
 *
 * 6.2.5 构造器
 * 和Java一样，Scala构造对象也需要调用构造方法，并且可以有任意多个构造方法。
 * Scala类的构造器包括：主构造器和辅助构造器
 *
 * 1）基本语法
 *      class 类名(形参列表) {  // 主构造器
 *          // 类体
 *          def  this(形参列表) {  // 辅助构造器
 *          }
 *          def  this(形参列表) {  //辅助构造器可以有多个...
 *          }
 *      }
 *  说明：
 *  （1）辅助构造器，函数的名称this，可以有多个，编译器通过参数的个数来区分。
 *  （2）辅助构造方法不能直接构建对象，必须直接或者间接调用主构造方法。
 *  （3）构造器调用其他另外的构造器，要求被调用构造器必须提前声明。
 *
 * 2）案例实操：见Cat
 *
 * 6.2.6 构造器参数
 * 1）说明
 *    Scala类的主构造器函数的形参包括三种类型：未用任何修饰、var修饰、val修饰
 *    （1）未用任何修饰符修饰，这个参数就是一个局部变量
 *    （2）var修饰参数，作为类的成员属性使用，可以修改
 *    （3）val修饰参数，作为类只读属性使用，不能修改
 * 2）案例实操：见Dog
 */

// Scala语法中，类并不声明为public，所有这些类都具有公有可见性（即默认就是public）
class MalePerson {

  // 定义属性
  var name: String = "bobo"

  // _表示给属性一个默认值
  var age: Int = _

  // 给属性sex添加 getter 和 setter方法
  @BeanProperty var sex: String = "男"

  def sum(n1: Int, n2: Int): Int = {
    n1 + n2
  }

}

object MalePerson {
  def main(args: Array[String]): Unit = {
    val person: MalePerson = new MalePerson
    println(person.name)
    person.setSex("男")
    println(person.getSex)
    println(person.sum(10, 20))
  }
}

// 一个Scala源文件可以包含多个类
class TeacherNew {

}

// （1）如果主构造器无参数，小括号可省略，构建对象时调用的构造方法的小括号也可以省略。
//class Cat() {
class Cat {
  var name: String = _
  var age: Int = _

  def this(age: Int) {
    // this
    this()
    this.age = age
    println("辅助构造器")
  }

  def this(age: Int, name: String) {
    this(age)
    this.name = name
    println("辅助构造器")
  }

  println("主构造器")
}

class Dog(name: String, var age: Int, val sex: String) {

}

object Dog {
  def main(args: Array[String]): Unit = {
    var dog = new Dog("哈士奇",2,"公的")

    // 未使用任何修饰符修饰，这个参数就是一个局部变量
    // println(dog.name)

    // var修饰参数，作为类的成员属性使用，可以修改
    dog.age = 19
    println(dog.age)

    // val修饰的参数，作为类的只读属性使用，不能修改
    // dog.sex = "母狗"
    println(dog.sex )
  }
}


object TestClassAndObject {

}

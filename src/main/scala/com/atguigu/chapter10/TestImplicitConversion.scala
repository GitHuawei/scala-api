package com.atguigu.chapter10

import com.atguigu.chapter10.TestTransform.Teacher

/**
 * 第10章 隐式转换
 *
 * 10.1 隐式函数
 * 1）说明
 * 隐式转换可以在不需改任何代码的情况下，扩展某个类的功能。
 * 2）案例实操：见 TestImplicitFunction
 * 需求：通过隐式转化为Int类型增加方法。
 */
class MyRichInt(val self: Int) {
  def myMax(i: Int): Int = {
    if (self < i) i else self
  }

  def myMin(i: Int): Int = {
    if (self > i) i else self
  }
}

object TestImplicitFunction {

  implicit def convert(arg: Int): MyRichInt = {
    new MyRichInt(arg)
  }

  def main(args: Array[String]): Unit = {
    println(2.myMax(1))
  }
}

/**
 * 10.2 隐式参数
 * 普通方法或者函数可以通过implicit关键字声明隐式参数，调用该方法时，
 * 就可以传入该参数，编译器会再相应的作用域寻找符合条件的隐式值。
 * 1）说明
 * （1）同一个作用域中，相同类型的隐式值只能有一个
 * （2）编译器按照隐式参数的类型去寻找对应类型的隐式值，与隐式值的名称无关。
 * （3）隐式参数优先于默认参数
 * 2）案例实操：见TestImplicitParameter
 */
object TestImplicitParameter {
  implicit val str : String = "hello world"

  def hello(implicit arg : String = "good bey world!"): Unit = {
    println(arg)
  }

  def main(args: Array[String]): Unit = {
    hello
  }
}

/**
 * 10.3 隐式类
 * 在Scala2.10后提供了隐式类，可以使用implicit声明类，隐式类的非常强大，
 * 同样可以扩展类的功能，在集合中隐式类会发挥重要的作用。
 * 1）隐式类说明
 * （1）其所带的构造参数有且只能有一个
 * （2）隐式类必须被定义在“类”或“伴生对象”或“包对象”里，即隐式类不能是顶级的。
 * 2）案例实操：见TestImplicitClass
 */
object TestImplicitClass {
  implicit class MyRichInt (arg : Int) {
    def myMax(i: Int) : Int = {
      if(arg < i) i else arg
    }

    def myMin(i: Int) = {
      if(arg < i) arg else i
    }
  }

  def main(args: Array[String]): Unit = {
    println(1.myMax(3))
  }
}

/**
 * 10.4 隐式解析机制
 * 1）说明
 * （1）首先会在当前代码作用域下查找隐式实体（隐式方法、隐式类、隐式对象）。（一般是这种情况）
 *
 * （2）如果第一条规则查找隐式实体失败，会继续在隐式参数的类型的作用域里查找。
 * 类型的作用域是指与该类型相关联的全部伴生对象以及该类型所在包的包对象。
 *
 * 3）案例实操：见TestTransform
 */
object TestTransform extends PersonTrait1 {

  def main(args: Array[String]): Unit = {
    // 首先会在当前代码作用域下查找隐式实体
    val teacher: Teacher = new Teacher()
    teacher.eat()
    teacher.say()
  }

  class Teacher {
    def eat(): Unit = {
      println("eat...")
    }
  }


}


trait PersonTrait1 {

}

object PersonTrait1 {
  implicit class Person5(user: Teacher) {
    def say(): Unit = {
      println("say ...")
    }
  }
}


class TestImplicitConversion {

}

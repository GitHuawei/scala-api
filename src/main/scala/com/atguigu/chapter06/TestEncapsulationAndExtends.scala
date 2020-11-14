package com.atguigu.chapter06

/**
 * 6.3 封装
 * 封装就是把抽象出的数据和对数据的操作封装在一起，数据被保护在内部，程序的其它部分只有通过被授权的操作
 * （成员方法），才能对数据进行操作。Java封装操作如下，
 *    （1）将属性进行私有化
 *    （2）提供一个公共的set方法，用于对属性赋值
 *    （3）提供一个公共的get方法，用于获取属性的值
 *
 * Scala中的public属性，底层实际为private，并通过get方法（obj.field()）和set方法（obj.field_=(value)）
 * 对其进行操作。所以Scala并不推荐将属性设为private，再为其设置public的get和set方法的做法。
 * 但由于很多Java框架都利用反射调用getXXX和setXXX方法，有时候为了和这些框架兼容，也会为Scala的属性设置
 * getXXX和setXXX方法（通过@BeanProperty注解实现）。
 *
 * 6.4 继承
 * 1）基本语法
 *      class 子类名 extends 父类名  { 类体 }
 *        （1）子类继承父类的属性和方法
 *        （2）scala是单继承
 * 2）案例实操。见Person11
 * （1）子类继承父类的属性和方法
 * （2）继承的调用顺序：父类构造器->子类构造器
 *
 */
object TestEncapsulationAndExtends {
  def main(args: Array[String]): Unit = {
    new Emp11("张三", 29,1001);
  }
}

class Person11(nameParam: String) {
  var name = nameParam
  var age: Int = _

  def this(nameParam: String, ageParam: Int) {
    this(nameParam)
    this.age = ageParam
    println("父类辅助构造器")
  }

  println("父类主构造器")
}

class Emp11(nameParam: String, ageParam: Int) extends Person11(nameParam, ageParam) {
  var empNo: Int = _

  def this(nameParam: String, ageParam: Int, empNoParam: Int) {
    this(nameParam, ageParam)
    this.empNo = empNoParam
    println("子类的辅助构造器")
  }

  println("子类主构造器")
}
























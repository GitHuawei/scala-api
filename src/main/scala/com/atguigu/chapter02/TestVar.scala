package com.atguigu.chapter02

object TestVar {

  def main(args: Array[String]): Unit = {
    // 声明变量时，类型可以省略，编译器自动推导，即类型推导
    // var age:Int = 18
    var age = 18
    age = 30

    // 类型确定以后，就不能修改，说明Scala是强数据类型语言
    //  age = "tom"

    // 变量声明时，必须要有初始值
    //  var name

    // 在声明/定义一个变量时，可以使用var或者val来修饰，var修饰的变量可改变，val修饰的变量不可改
    var num1 = 10
    val num2 = 20

    num1 = 30
    //    num2 = 40 // 不可变

    // p1是var修饰的，p1的属性可以变，而且p1本身也可以变
    var p1 = new Person()
    p1.name = "dalang"
    p1 = null

    // p2是val修饰的，那么p2本身就不可变(即p2的内存地址不能变)，但是，p2的属性是可以改变的，因为属性并没有用 val修饰
    val p2 = new Person()

//    p2 = null

    p2.name = "jinlian"
  }

}

class Person {
  var name : String = "jinlian";
}

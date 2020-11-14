package com.atguigu.chapter06

class Person {

  private var name: String = "bobo"
  protected var age: Int = 18

  // private[包名]增加包访问权限，包名下的其他类也可以使用
  private[chapter06] var sex: String = "男"

  def say(): Unit = {
    println(name)
  }

}

object Person {
  def main(args: Array[String]): Unit = {
    val person: Person = new Person

    person.say()

    println(person.name)
    println(person.age)
  }
}

class Teacher extends Person {

  def test(): Unit = {
    this.age
    this.sex
  }

}

class Animal {
  def test: Unit = {
    new Person().sex
  }
}

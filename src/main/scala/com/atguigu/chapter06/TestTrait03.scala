package com.atguigu.chapter06

/**
 * 6.7.5 特质自身类型
 *  1）说明
 *    自身类型可实现依赖注入的功能。
 *
 *  2）案例实操
 */
object TestTrait03 {

}

class User(val name: String, val age: Int)

trait Dao {
  def insert(user: User) = {
    println("insert into database: " + user.name)
  }
}

trait APP {
  _: Dao =>

  def login(user: User): Unit = {

    println("login：" + user.name)
    insert(user)
  }
}

object MyApp extends APP with Dao {
  def main(args: Array[String]): Unit = {
    login(new User("bobo", 11))
  }
}



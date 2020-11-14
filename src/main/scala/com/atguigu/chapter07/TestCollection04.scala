package com.atguigu.chapter07

import scala.collection.mutable

/**
 * 7.4 Set集合
 *  默认情况下，Scala使用的是不可变集合，如果你想使用可变集合，需要引用 scala.collection.mutable.Set 包
 *
 * 7.4.1 不可变Set
 *  1）说明
 *  （1）Set默认是不可变集合，数据无序
 *  （2）数据不可重复
 *  （3）遍历集合
 *  2）案例实操：见TestImmutableSet
 *
 * 7.4.2 可变mutable.Set
 *  1）说明
 *  （1）创建可变集合mutable.Set
 *  （2）打印集合
 *  （3）集合添加元素
 *  （4）向集合中添加元素，返回一个新的Set
 *  （5）删除数据
 *  2）案例实操：见TestMutableSet
 */
object TestCollection04 {

}

object TestImmutableSet {
  def main(args: Array[String]): Unit = {

    // Set默认是不可变集合，数据无序
    val immutableSet: Set[Int] = Set(1, 2, 3, 4, 5, 6)
    println(immutableSet.mkString(", "))

    // 数据不可重复
    val immutableSet2: Set[Int] = Set(1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3)
    println(immutableSet2.mkString(", "))

    // 遍历集合
    immutableSet.foreach(println)

  }
}

object TestMutableSet {
  def main(args: Array[String]): Unit = {

    // 创建可变集合mutable
    val mutableSet: mutable.Set[Int] = mutable.Set(1, 2, 3, 4, 5)

    // 往集合中添加元素
    mutableSet.add(2)
    mutableSet.+=(7)

    println(mutableSet.mkString(", "))

    // 删除数据
    mutableSet.remove(7)
    mutableSet -= (1)

    println(mutableSet.mkString(", "))

    // 遍历集合
    mutableSet.foreach(println)

  }
}

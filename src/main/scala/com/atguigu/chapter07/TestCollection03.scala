package com.atguigu.chapter07

import scala.collection.mutable.ListBuffer

/**
 * 7.3 Seq集合（List）
 *
 * 7.3.1 不可变List
 *  1）说明
 *  （1）List默认为不可变集合
 *  （2）创建一个List（数据有顺序，可重复）
 *  （3）遍历List
 *  （4）List增加数据
 *  （5）集合间合并：将一个整体拆成一个一个的个体，称为扁平化
 *  （6）取指定数据
 *  （7）空集合Nil
 *  2）案例实操：见TestImmutableList
 *
 * 7.3.2 可变ListBuffer
 * 1）说明
 * （1）创建一个可变集合ListBuffer
 * （2）向集合中添加数据
 * （3）打印集合数据
 * 2）案例实操：见TestMutableList
 */
object TestList03 {

}

object TestImmutableList {
  def main(args: Array[String]): Unit = {
    // 创建一个List(数据由顺序，可重复)
    val list: List[Int] = List(1, 2, 3, 4, 3)
    println(list.mkString(", "))

    // 空集合Nil
    var emptyList: Nil.type = Nil
    println(emptyList)

    var list1: List[Int] = 1 :: 2 :: 3 :: 4 :: 5 :: Nil

    // List增加数据
    // ::的运算规则从右向左
    val newList: List[Int] = 7 :: 6 :: 5 :: list
    println(newList.mkString(","))

    // 添加到第一个元素位置
    val newList2: List[Int] = list.+:(5)
    println(newList2.mkString(", "))

    val list2: List[Int] = List(8, 9)

    // 集合间合并：将一个整体拆成一个个的个体，称之为扁平化
    val list3: List[Int] = list ::: list2
    println(list3.mkString(", "))

    // 取指定数据
    println(list(2))

    // 遍历集合
    list.foreach(println)
  }
}

object TestMutableList {
  def main(args: Array[String]): Unit = {
    // 创建一个可变集合
    val mutableList: ListBuffer[Int] = ListBuffer(1, 2, 3, 4, 5, 6, 7)

    // 向集合中添加数据
    mutableList.append(8, 9, 10)

    println(mutableList.mkString(", "))

    // 向集合中添加数据
    mutableList.+=(11)

    println(mutableList.mkString(", "))
  }
}

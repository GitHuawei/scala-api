package com.atguigu.chapter07

import scala.collection.mutable

/**
 * 7.5 Map集合
 *      Scala中的Map和Java类似，也是一个散列表，它存储的内容也是键值对（key-value）映射，
 *  Scala中不可变的Map是有序的，可变的Map是无序的。
 *
 * 7.5.1 不可变Map
 *  1）说明
 *  （1）创建不可变集合Map
 *  （2）循环打印
 *  （3）访问数据
 *  （4）如果key不存在，返回0
 *  2）案例实操：见TestImmutableMap
 *
 * 7.5.2 可变Map
 *  1）说明
 *  （1）创建可变集合
 *  （2）打印集合
 *  （3）向集合增加数据
 *  （4）删除数据
 *  （5）修改数据
 *  2）案例实操：TestMutableMap
 */
object TestCollection05 {

}

object TestImmutableMap {
  def main(args: Array[String]): Unit = {

    // 创建不可变的Map
    val immutableMap: Map[String, Int] = Map("a" -> 1, "b" -> 2, "c" -> 3)

    // 访问数据
    for (elem <- immutableMap.keys) {

      // 使用get访问map集合的数据，会返回特殊类型Option(选项)：有值(Some)，无值(None)
      println("key: " + elem + ", value : " + immutableMap.getOrElse(elem, 0))
    }

    println("--------------------------")

    // 遍历Map
    immutableMap.foreach(println)
    println("--------------------------")
    immutableMap.foreach((kv) => {
      println(kv)
    })
  }
}

object MutableMap {
  def main(args: Array[String]): Unit = {

    // 创建可变Map
    val mutableMap: mutable.Map[String, Int] = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)

    // 向Map中增加数据
    mutableMap.put("d", 4)
    mutableMap.+=("e" -> 5)

    mutableMap.foreach(println)

    println("-----------------------------------------")

    // 将数值4添加到Map中，并把Map中原值1返回
    val maybeInt: Option[Int] = mutableMap.put("a", 4)
    println(maybeInt.getOrElse(0))

    println("-----------------------------------------")

    // 删除数据
    mutableMap.remove("a")
    mutableMap.-=("c")

    mutableMap.foreach(println)
  }
}

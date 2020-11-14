package com.atguigu.chapter07

/**
 * 7.7 集合常用函数
 *
 *  7.7.1 基本属性和常用操作
 *
 *  1）说明
 *  （1）获取集合长度
 *  （2）获取集合大小
 *  （3）循环遍历
 *  （4）迭代器
 *  （5）生成字符串
 *  （6）是否包含
 *
 *  2）案例实操
 */
object TestCollection07 {

  def main(args: Array[String]): Unit = {
    // 1、获取集合长度
    val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
    println(list.length)
    println("-------------------------------")

    //2、获取集合大小
    println(list.size)
    println("-------------------------------")

    //3、循环遍历
    list.foreach(println)
    println("-------------------------------")

    //4、迭代器
    for (elem <- list.iterator) {
      println(elem)
    }
    println("-------------------------------")

    //5、生成字符串
    println(list.mkString(", "))
    println("-------------------------------")

    //6、是否包含
    val flag: Boolean = list.contains(2)
    println(flag)
    println("-------------------------------")
  }
}

/**
 * 7.7.2 衍生集合
 *  1）说明
 *  （1）获取集合的头
 *  （2）获取集合的尾（不是头的就是尾）
 *  （3）集合最后一个数据
 *  （4）集合初始数据（不包含最后一个）
 *  （5）反转
 *  （6）取前（后）n个元素
 *  （7）去掉前（后）n个元素
 *  （8）并集
 *  （9）交集
 *  （10）差集
 *  （11）拉链
 *  （12）滑窗
 *
 *  2）案例实操
 */
object TestAdvanceOperate {
  def main(args: Array[String]): Unit = {
    var list1: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
    var list2: List[Int] = List(4, 5, 6, 7, 8, 9, 10)

    //1、获取集合的头
    println(list1.head)

    //2、获取集合的尾
    println(list1.tail)

    //3、集合最后一个数据
    println(list1.last)

    //4、集合初始数据（不包含最后一个）
    println(list1.init)

    //5、反转
    println(list1.reverse)

    //6、取前（后）n个元素
    println(list1.take(3))
    println(list1.takeRight(3))

    //7、 去掉前（后）n个元素
    println(list1.drop(3))
    println(list1.dropRight(3))

    //8、并集
    println(list1.union(list2))

    //9、交集
    println(list1.intersect(list2))

    //10、差集
    println(list1.diff(list2))

    //11、拉链
    // 如果两个集合的元素个数不相等，那么会将同等数量的数据进行拉链，多余的数据省略不用
    println(list1.zip(list2))

    println("-----------------------------")

    //12、滑窗
    list1.sliding(2, 3).foreach(println)
  }
}
package com.atguigu.chapter07

import scala.collection.mutable

/**
 * 7.7.3 集合计算初级函数
 *  1）说明
 *  （1）求和
 *  （2）求乘积
 *  （3）最大值
 *  （4）最小值
 *  （5）排序
 *  2）实操
 */
object TestCollection08 {
  def main(args: Array[String]): Unit = {

    val list: List[Int] = List(1, 5, -3, 4, 2, -7, 6)

    // 1、求和
    println(list.sum)

    // 2、求乘积
    println(list.product)

    // 3、最大值
    println(list.max)

    // 4、最小值
    println(list.min)

    //5、排序
    //5.1、按照元素大小排序
    println(list.sortBy(x => x))

    // 5.2、按照元素的绝对值大小排序
    list.sortBy(x => x.abs)

    // 5.3、按照元素大小升序排序
    println(list.sortWith(_ < _))

    //5.4、按照元素大小降序排序
    print(list.sortWith( _ > _))
  }
}

/**
 * 7.7.4 集合计算高级函数
 *  1）说明
 *  （1）过滤
 *  （2）转化/映射
 *  （3）扁平化
 *  （4）扁平化+映射 注：flatMap相当于先进行map操作，在进行flatten操作
 *  （5）分组
 *  （6）简化（规约）
 *  （7）折叠
 *  2）实操
 */
object TestAdvanceCompute {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val nestedList: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))

    val wordList: List[String] = List("hello world", "hello atguigu", "hello scala")

    // 1、过滤
    println(list.filter(_ % 2 == 0))

    // 2、转化/映射
    println(list.map(_ << 2))

    // 3、扁平化
    println(nestedList.flatten)

    // 4、扁平化 + 映射
    println(wordList.flatMap(_.split(" ")))

    //5、分组
    println(list.groupBy(_ % 2 == 0))

    println(wordList.flatMap(_.split(" ")).groupBy(word => word).map(tuple => {
      (tuple._1, tuple._2.length)
    }))

  }
}

/**
 * 3）Reduce方法
 *    Reduce简化（规约） ：通过指定的逻辑将集合中的数据进行聚合，从而减少数据，最终获取结果。
 *  案例实操
 */
object TestReduce {
  def main(args: Array[String]): Unit = {

    val list: List[Int] = List(1, 2, 3, 4)

    // 将数据两两结合，实现运算规则
    val result: Int = list.reduce(_ - _)
    println("result : " + result)

    // 从源码的角度，reduce底层调用的其实就是reduceLeft
    val result2: Int = list.reduceLeft(_ - _)
    println("result2 : " + result2)

    // reduceRight 1-(2-(3-4)) = -2
    val result3: Int = list.reduceRight(_ - _)
    println("result3 : " + result3)
  }
}

/**
 * 4）Fold方法
 *  Fold折叠：化简的一种特殊情况。
 *  （1）案例实操：fold基本使用
 */
object TestFold {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 2, 3, 4)

    // fold方法使用了函数柯里化，存在两个参数列表
    // 第一个参数列表为：零值（初始值）
    // 第二个参数列表为：

    // ((((2 - 1) - 2) - 3) - 4)
    println(list.fold(2)(_ - _))
    println(((((2 - 1) - 2) - 3) - 4))

    // fold底层其实为foldLeft
    println(list.foldLeft(2)(_ - _))

    println("---------------------------")

    // 关于foldRight的理解
    // 第一步：将list倒序，变成(4,3,2,1)
    // 1 - (2 - (3 - (4 - 10)))
    println(list.foldRight(10)(_ - _))
    println(1 - (2 - (3 - (4 - 10))))

    println("---------------------------")

    // 两个Map合并
    val map1: mutable.Map[String, Int] = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    val map2: mutable.Map[String, Int] = mutable.Map("a" -> 4, "b" -> 5, "d" -> 6)

    val map3: mutable.Map[String, Int] = map1.foldLeft(map2) {
      (map, kv) => {
        val k: String = kv._1
        val v: Int = kv._2

        map(k) = map.getOrElse(k, 0) + v
        map
      }
    }

    map3.foreach(println)
  }
}














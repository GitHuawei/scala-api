package com.atguigu.chapter07

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * 7.2 数组
 *
 * 7.2.1 不可变数组
 *  1）第一种方式定义数组
 *    定义：val arr1 = new Array[Int](10)
 *  （1）new是关键字
 *  （2）[Int]是指定可以存放的数据类型，如果希望存放任意数据类型，则指定Any
 *  （3）(10)，表示数组的大小，确定后就不可以变化
 *
 *  2）第二种方式定义数组
 *  val arr1 = Array(1, 2)
 *  （1）在定义数组时，直接赋值
 *  （2）使用apply方法创建数组对象
 *
 *  3）案例实操：见TestImmutableArray
 *
 * 7.2.2 可变数组
 *  1）定义变长数组
 *    val mutableArray = ArrayBuffer[Any](3, 2, 5)
 *  （1）[Any]存放任意数据类型
 *  （2）(3, 2, 5)初始化好的三个元素
 *  （3）ArrayBuffer需要引入scala.collection.mutable.ArrayBuffer
 *  2）注意
 *  （1）ArrayBuffer是有序的集合
 *  （2）增加元素使用的是append方法()，支持可变参数
 *  3）案例实操：见TestMutableArray
 *
 * 7.2.3 不可变数组与可变数组的转换
 *  1）说明
 *      arr1.toBuffer  //不可长数组转可变数组
 *      arr2.toArray  //可变数组转不可变数组
 *  （1）arr2.toArray返回结果才是一个不可变数组，arr2本身没有变化
 *  （2）arr1.toBuffer返回结果才是一个可变数组，arr1本身没有变化
 *  2）案例实操：见TestMutableImmutable
 *
 * 7.2.4 多维数组
 *  1）多维数组定义
 *    val arr = Array.ofDim[Double](3,4)
 *    说明：二维数组中有三个一维数组，每个一维数组中有四个元素
 *  2）案例实操：见DimArray
 */
object TestList02 {

}

object TestImmutableArray {
  def main(args: Array[String]): Unit = {

    // 数组定义
    val arr01: Array[Int] = new Array[Int](4)
    println(arr01.length)

    // 数组赋值
    arr01(0) = 2
    println(arr01.mkString(","))

    arr01(1) = 10
    println(arr01.mkString(","))

    // 采用方法的形式给数组赋值
    arr01.update(0, 6)
    arr01.mkString(",")
    println(arr01.mkString(","))

    // 遍历数组
    println("普通方式遍历：")
    for (i <- arr01) {
      println(i)
    }

    // 简化遍历
    println("简化遍历：")

    def printx(element: Int): Unit = {
      println(element)
    }

    arr01.foreach(printx)

    println("能省则省之后，最简单的方式遍历：")
    arr01.foreach(println)

    // 增加元素(由于创建的是不可变数组，增加元素，其实是产生新的数组)
    val arr02: Array[Int] = arr01 :+ 5
    println(arr02.mkString(","))
    println(arr01.eq(arr02))

    println("---------------------------")

    // 第二种方式定义数组
    var arr03: Array[Int] = Array(1,2,3,4,5)
    arr03.foreach(println)
  }
}

object TestMutableArray {
  def main(args: Array[String]): Unit = {

    // 创建可变数组
    val mutableArray: ArrayBuffer[Any] = ArrayBuffer(1, 2, 3)

    // 遍历数组
    mutableArray.foreach(println)
    println("mutableArray.hash = " + mutableArray.hashCode())

    // 增加元素使用的是append方法()，支持可变参数
    mutableArray += (4) // 追加数据
    mutableArray.append(5, 6, 7) // 向数组最后追加数据
    mutableArray.insert(7, 8) // 向指定的位置插入数据
    mutableArray.foreach(println)
    println("mutableArray.hash = " + mutableArray.hashCode())

    // 修改元素
    mutableArray(0) = 666
    println(mutableArray.mkString(","))
  }
}

object TestMutableImmutable {
  def main(args: Array[String]): Unit = {

    val arrayBuffer: ArrayBuffer[Int] = ArrayBuffer[Int](1, 2, 3, 4, 5)

    arrayBuffer.append(6,7,8,9,10)

    // ArrayBuffer => Array
    // 返回的结果是一个新的定长数组集合；arrayBuffer它没有变化

    val array: Array[Int] = arrayBuffer.toArray

    // Array => ArrayBuffer
    // 返回一个变长数组；array没有任何变化，仍然是定长数组
    val newArrayBuffer: mutable.Buffer[Int] = array.toBuffer
    newArrayBuffer.append(11,12,13)

  }
}

object DimArray {
  def main(args: Array[String]): Unit = {

    // 创建了一个二维数组, 有三个元素，每个元素是，含有4个元素一维数组
    val dimArray: Array[Array[Int]] = Array.ofDim[Int](3, 4)

    dimArray(1)(2) = 3

    // 遍历二维数组
    dimArray.foreach(array => println(array.mkString(", ")))
  }
}


















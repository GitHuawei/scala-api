package com.atguigu.chapter07

import scala.collection.mutable.ListBuffer

/**
 * 第7章 集合
 *
 * 7.1 集合简介
 *  1）说明
 *  （1）Scala的集合有三大类：序列Seq、集Set、映射Map，所有的集合都扩展自Iterable特质。
 *  （2）对于几乎所有的集合类，Scala都同时提供了可变和不可变的版本，分别位于以下两个包
 *      不可变集合：scala.collection.immutable
 *      可变集合：  scala.collection.mutable
 *  2）案例实操
 *  （1）Scala不可变集合，就是指该集合对象不可修改，每次修改就会返回一个新对象，而不会对原对象进行修改。
 *  （2）可变集合，就是这个集合可以直接对原对象进行修改，而不会返回新的对象。
 *
 * 7.1.1 不可变集合继承图（见word）
 *
 *  1）Set、Map是Java中也有的集合
 *  2）Seq是Java没有的，我们发现List归属到Seq了，因此这里的List就和Java不是同一个概念了
 *  3）我们前面的for循环有一个 1 to 3，就是IndexedSeq下的Vector
 *  4）String也是属于IndexSeq
 *  5）我们发现经典的数据结构比如Queue和Stack被归属到LinerSeq
 *  6）大家注意Scala中的Map体系有一个SortedMap，说明Scala的Map可以支持排序
 *  7）IndexSeq和LinearSeq的区别：
 *  （1）IndexSeq是通过索引来查找和定位，因此速度快，比如String就是一个索引集合，通过索引即可定位
 *  （2）LineaSeq是线型的，即有头尾的概念，这种数据结构一般是通过遍历来查找
 *
 * 7.1.2 可变集合继承图（见word）
 *
 */
object TestCollection01 {
  def main(args: Array[String]): Unit = {

    // 不可变list
    val immutableList: List[Int] = List(1, 2, 3, 4, 5, 6)

    // 对不可变List进行修改，在头部添加一个元素0
    val newImmutableList: List[Int] = 0 +: immutableList

    println(immutableList.mkString(","))
    println(newImmutableList.mkString(","))

    println("-------------------------------------")

    // 可变list
    val mutableList: ListBuffer[Int] = ListBuffer(1, 2, 3, 4, 5, 6)

    // 对可变List进行修改，在头部添加一个元素0
    val selfMutableList: ListBuffer[Int] = 0 +=: mutableList

    println(mutableList.mkString(","))
    println(selfMutableList.mkString(","))
    println(mutableList.eq(selfMutableList))

  }
}

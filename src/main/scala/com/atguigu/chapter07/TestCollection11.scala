package com.atguigu.chapter07

import scala.collection.parallel.immutable.ParSeq
import scala.collection.{immutable, mutable}

/**
 * 7.8 队列
 * 1）说明
 * Scala也提供了队列（Queue）的数据结构，队列的特点就是先进先出。进队和出队的方法分别为enqueue和dequeue。
 * 2）案例实操
 */
object TestCollection11 {

  def main(args: Array[String]): Unit = {
    val queue: mutable.Queue[String] = new mutable.Queue[String]()

    queue.enqueue("a", "b", "c")
    println(queue)

    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())

    println(queue)


  }
}

/**
 * 7.9 并行集合
 * 1）说明
 * Scala为了充分使用多核CPU，提供了并行集合（有别于前面的串行集合），用于多核环境的并行计算。
 * 2）案例实操
 */
object TestPar {
  def main(args: Array[String]): Unit = {

    val result1: immutable.IndexedSeq[String] = (0 to 100).map {
      case _ => Thread.currentThread().getName
    }

    val result2: ParSeq[String] = (0 to 100).par.map {
      case _ => Thread.currentThread().getName
    }

    println(result1)
    println(result2)

  }
}

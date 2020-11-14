package com.atguigu.chapter07

/**
 * 7.7.6 复杂WordCount案例
 *
 * 1）方式一
 * 2）案例实操
 */
object WordCount {
  def main(args: Array[String]): Unit = {

    // 第一种方式（不通用）
    val tupleList: List[(String, Int)] = List(("Hello Scala Spark World ", 4), ("Hello Scala Spark", 3), ("Hello Scala", 2), ("Hello", 1))

    val stringList: List[String] = tupleList.map(t => (t._1 + " ") * t._2)
    // println(stringList)

    val words: List[String] = stringList.flatMap(_.split(" "))
    // println(words)

    // 在 map 中，如果传进来什么就返回什么，不要用_省略
    val groupMap: Map[String, List[String]] = words.groupBy(word => word)
    // println(groupMap)

    // 过滤空值
    val groupMapFilter: Map[String, List[String]] = groupMap.filter(tuple => !tuple._1.isEmpty)
    // println(groupMapFilter)

    val wordToCount: Map[String, Int] = groupMapFilter.map(tuple => (tuple._1, tuple._2.size))
    // println(wordToCount)

    val wordToCountList: List[(String, Int)] = wordToCount.toList
    // println(wordToCountList)

    val orderedList: List[(String, Int)] = wordToCountList.sortWith((t1, t2) => t1._2 > t2._2)
    // println(orderedList)

    val result: List[(String, Int)] = orderedList.take(3)
    println(result)
  }
}

/**
 * 3）方式二
 * 4）案例实操
 */
object WordCount2 {

  def main(args: Array[String]): Unit = {

    val tuples: List[(String, Int)] = List(("Hello Scala Spark World", 4), ("Hello Scala Spark", 3), ("Hello Scala", 2), ("Hello", 1))

    val wordToCountList: List[(String, Int)] = tuples.flatMap(tuple => tuple._1.split(" ").map(word => (word, tuple._2)))
    // println(wordToCountList)

    val wordToTupleMap: Map[String, List[(String, Int)]] = wordToCountList.groupBy(tuple => tuple._1)
    // println(wordToTupleMap)

    val stringToInts: Map[String, List[Int]] = wordToTupleMap.mapValues(data => data.map(t => t._2))
    // println(stringToInts)

    val stringToInt: Map[String, Int] = stringToInts.map(tuple => (tuple._1, tuple._2.sum))
    println(stringToInt)

  }

}

object TestCollection10 {

}

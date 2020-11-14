package com.atguigu.chapter07

/**
 * 7.7.5 普通WordCount案例
 *
 * 1）需求
 * 单词计数：将集合中出现的相同的单词，进行计数，取计数排名前三的结果
 *
 * 2）需求分析
 *
 * 3）案例实操
 */
object TestWordCount {
  def main(args: Array[String]): Unit = {
    // 单词计数：将集合中出现的相同的单词，进行计数，取计数排名前三的结果
    val stringList: List[String] = List("Hello Scala Hbase kafka", "Hello Scala Hbase", "Hello Scala", "Hello")

    //1、将每一个字符串转换成一个一个的单词
    val wordList: List[String] = stringList.flatMap(str => str.split(" "))
    // println(wordList);

    //2、将相同的单词放在一起
    val strMap: Map[String, List[String]] = wordList.groupBy(word => word)
    // println(strMap)

    //3、对相同的单词进行计数
    val wordToCountMap: Map[String, Int] = strMap.map(tuple => (tuple _1, (tuple _2).length))
    // println(wordToCountMap)

    //4、对计数完成后的结果进行排序
    val wordToCountList: List[(String, Int)] = wordToCountMap.toList
    // println(wordToCountList)

    val sortedList: List[(String, Int)] = wordToCountList.sortWith((x, y) => x._2 > y._2)
    // println(sortedList)

    //5、取前3个
    val wordCountResult: List[(String, Int)] = sortedList.take(3)
    println(wordCountResult)
  }


}


object TestCollection09 {

}

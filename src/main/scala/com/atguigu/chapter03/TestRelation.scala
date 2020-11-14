package com.atguigu.chapter03

/**
 * 3.2  关系运算符
 */
object TestRelation {

  def main(args: Array[String]): Unit = {
    var a: Int = 2
    var b: Int = 1

    println(a > b) // true
    println(a >= b) // true
    println(a <= b) // false
    println(a < b) // false
    println("a==b：" + (a == b)) // false

    println(a != b) //true

    /* Java和Scala中关于==的区别
    *    Java：
    *     ==比较两个变量本身的值，即两个对象在内存中的首地址；
    *     equals比较字符串中所包含的内容是否相同。
    *
    *   Scala：
    *     ==更加类似于Java中的equals；
    *     a.eq(b) 类似于Java中的 ==
    */
    var s1: String = "abc"
    var s2: String = new String("abc")

    println("s1 == s2 : " + (s1 == s2)) // true
    println("s1.eq(s2)：" + (s1.eq(s2))) // false
  }


}

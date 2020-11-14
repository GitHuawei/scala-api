package com.atguigu.chapter08

/**
 * 8.4 变量声明中的模式匹配
 */
case class Person111(name: String, age: Int)

object TestMatchVariable {
  def main(args: Array[String]): Unit = {
    val (x, y) = (1, 2)

    println(s"x=$x, y=$y")

    val Array(first, second, _*) = Array(1, 7, 2, 9)
    println(s"first=$first, second=$second")

    val Person111(name, age) = Person111("zhangsan", 16)
    println(s"name=$name, age=$age")
  }
}

/**
 * 8.5 for表达式中的模式匹配
 */
object TestMatchFor {
  def main(args: Array[String]): Unit = {
    val map: Map[String, Int] = Map("A" -> 1, "B" -> 2, "C" -> 3)
    for ((k, v) <- map) {
      // 直接将map中的k-v遍历出来
      println(k + " -> " + v)
    }

    println("-----------------------")

    // 遍历value=0的k-v，如果v不是0，过滤
    for ((k, 1) <- map) {
      println(k + " -> " + 1)
    }

    println("-----------------------")

    for ((k, v) <- map if v > 1) {
      println(k + " -> " + v)
    }
  }
}

/**
 * 8.6 偏函数中的模式匹配
 * 偏函数也是函数的一种，通过偏函数我们可以方便的对输入参数做更精确的
 * 检查。例如该偏函数的输入类型为List[Int]，而我们需要的是第一个元素
 * 是0的集合，这就是通过模式匹配实现的。
 * 1）偏函数定义
 * val second: PartialFunction[List[Int], Option[Int]] = {
 * case x :: y :: _ => Some(y)
 * }
 *
 * 注：该偏函数的功能是返回输入的List集合的第二个元素
 *
 * 2）偏函数原理
 * 上述代码会被scala编译器翻译成以下代码，与普通函数相比，只是多了一个
 * 用于参数检查的函数——isDefinedAt，其返回值类型为Boolean。
 */

object TestPartialFunc {
  val second: PartialFunction[List[Int], Option[Int]] = new PartialFunction[List[Int], Option[Int]] {

    //检查输入参数是否合格
    override def isDefinedAt(list: List[Int]): Boolean = list match {
      case x :: y :: _ => true
      case _ => false
    }

    //执行函数逻辑
    override def apply(list: List[Int]): Option[Int] = list match {
      case x :: y :: _ => Some(y)
    }
  }
}

/**
 * 3）偏函数使用
 * 偏函数不能像second(List(1,2,3))这样直接使用，因为这样会直接
 * 调用apply方法，而应该调用applyOrElse方法，如下
 * second.applyOrElse(List(1,2,3), (_: List[Int]) => None)
 * applyOrElse方法的逻辑为 if (ifDefinedAt(list)) apply(list) else default。
 * 如果输入参数满足条件，即isDefinedAt返回true，则执行apply方法，否则
 * 执行defalut方法，default方法为参数不满足要求的处理逻辑。
 * 4）	案例实操
 * （1）需求
 * 将该List(1,2,3,4,5,6,"test")中的Int类型的元素加一，并去掉字符串。
 * （2）实操
 * 方法一：
 * List(1,2,3,4,5,6,"test").filter(_.isInstanceOf[Int]).map(_.asInstanceOf[Int] + 1).foreach(println)
 * 方法二：
 * List(1, 2, 3, 4, 5, 6, "test").collect { case x: Int => x + 1 }.foreach(println)
 */


object TestPatternMatching03 {

}

package com.atguigu.chapter08

/**
 * 第8章 模式匹配
 * Scala 中的模式匹配类似于 Java 中的 switch 语法，但是更加强大。
 * 模式匹配语法中，采用 match 关键字声明，每个分支采用 case 关键字进行声明，当
 * 需要匹配时，会从第一个 case 分支开始，如果匹配成功，那么执行对应的逻辑代码，
 * 如果匹配不成功，继续执行下一个分支进行判断。如果所有 case 都不匹配，那么
 * 会执行 case _ 分支，类似于 Java 中 default 语句。
 *
 * 8.1 基本语法
 *
 * 1）说明
 * （1）如果所有 case 都不匹配，那么会执行 case _ 分支，类似于 Java 中 default 语句，
 * 若没有case _ 分支，那么会抛出MatchError。
 * （2）每个 case 中，不用 break 语句，自动中断 case。
 * （3）match case语句可以匹配任何类型，而不只是字面量。
 * （4）=> 后面的代码块，是作为一个整体执行，可以使用{}括起来，也可以不括。
 *
 * 2）案例实操：见 TestMatchCase
 */

object TestMatchCase {
  def main(args: Array[String]): Unit = {
    val a: Int = 10
    val b: Int = 20
    val operator: Char = 'd'

    val result: Any = operator match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case _ => "illegal"
    }

    println(result)
  }
}

/**
 * 8.2 模式守卫
 * 1）说明
 * 如果想要表达匹配某个范围的数据，就需要在模式匹配中增加条件守卫。
 * 2）案例实操：见TestMatchGuard
 */
object TestMatchGuard {

  def main(args: Array[String]): Unit = {
    def abs(x: Int) = x match {
      case i: Int if i >= 0 => i
      case i: Int if i < 0 => -i
      case _ => "type illegal"
    }

    println(abs(-6))
    println(abs(5))
  }
}

/**
 * 8.3 模式匹配类型
 * 8.3.1 匹配常量
 * 1）说明
 * Scala中，模式匹配可以匹配所有的字面量，包括字符串，字符，数字，布尔值等等。
 * 2）案例实操：见TestMatchVal
 */
object TestMatchVal {
  def main(args: Array[String]): Unit = {
    println(describe(5))
    println(describe("hello"))
    println(describe(true))
    println(describe('+'))
  }

  def describe(x: Any) = x match {
    case 5 => "Int five"

    case "hello" => "String hello"

    case true => "Boolean true"

    case '+' => "Char +"
  }
}

/**
 * 8.3.2 匹配类型
 * 1）说明
 * 需要进行类型判断时，可以使用前文所学的isInstanceOf[T]和asInstanceOf[T]，
 * 也可使用模式匹配实现同样的功能。
 * 2）案例实操：见TestMatchClass
 */

object TestMatchClass {
  def main(args: Array[String]): Unit = {

    // 泛型擦除
    println(describe(List(1, 2, 3, 4, 5, 6)))

    // 数组例外，可保留泛型
    println(describe(Array(1, 2, 3, 4, 5, 6)))
    println(describe(Array("abc")))

  }

  def describe(x: Any) = x match {
    case i: Int => "int"
    case s: String => "string"
    case m: List[_] => "List"
    case c: Array[Int] => "Array[Int]"
    case something => "something else " + something
  }
}

/**
 * 8.3.3 匹配数组
 * 1）说明
 * scala模式匹配可以对集合进行精确的匹配，例如匹配只有两个元素的、
 * 且第一个元素为0的数组。
 * 2）案例实操：见TestMatchArray
 */

object TestMatchArray {
  def main(args: Array[String]): Unit = {
    for (arr <- Array(Array(0), Array(1, 0), Array(0, 1, 0),
      Array(1, 1, 0), Array(1, 1, 0, 1), Array("hello", 90))) {

      // 对一个数组集合进行遍历
      val result: String = arr match {
        case Array(0) => "0" // 匹配Array(0)这个数组

        case Array(x, y) => x + ", " + y // 匹配有两个元素的数组，然后将元素值赋给对应的x, y

        case Array(0, _*) => "以0开头的数组"

        case _ => "something else"
      }

      println(result)
    }
  }
}

object TestPatternMatching01 {

}

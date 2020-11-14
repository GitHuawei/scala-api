package com.atguigu.chapter08

/**
 * 8.3.4 匹配列表
 * 1）方式一：见TestMatchList
 */

object TestMatchingList {
  def main(args: Array[String]): Unit = {
    //list是一个存放List集合的数组
    //请思考，如果要匹配 List(88) 这样的只含有一个元素的列表,并原值返回,应该怎么写

    for (list <- Array(List(0), List(1, 0), List(0, 0, 0), List(1, 0, 0), List(88))) {
      val result: String = list match {
        case List(0) => "0" // 匹配List(0)
        case List(x, y) => x + ", " + y // 匹配有两个元素的List
        case List(0, _*) => "0 ..."
        case _ => "something else"
      }

      println(result)
    }
  }
}

/**
 * 2）方式二
 */
object TestMatchList {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 2, 5, 6, 7)

    list match {
      case first :: second :: rest => print(first + "-" + second + "-" + rest)
      case _ => println("something else")
    }
  }
}

/**
 * 8.3.5 匹配元组
 */
object TestMatchTuple {
  def main(args: Array[String]): Unit = {
    // 对一个元组集合进行遍历

    for (tuple <- Array((0, 1), (1, 0), (1, 1), (1, 0, 2))) {

      val result: String = tuple match {
        case (0, _) => "0 ... " // 第一个元素是0的元组
        case (y, 0) => " " + y + "0" // 后一个元素是0的对偶元组

        case (a, b) => "" + a + " " + b
        case _ => "something else" // 默认
      }

      println(result)

    }
  }
}

/**
 * 8.3.6 匹配对象及样例类
 * 1）基本语法
 */
class User111(var name: String, var age: Int)

object User111 {
  def apply(name: String, age: Int): User111 = new User111(name, age)

  def unapply(user: User111): Option[(String, Int)] = {
    if (user == null)
      None
    else
      Some(user.name, user.age)
  }
}

object TestMatchUnapply {
  def main(args: Array[String]): Unit = {
    val user: User111 = User111("zhangsan", 11)
    val result: String = user match {
      case User111("zhangsan", 11) => "yes"
      case _ => "no"
    }

    println(result)
  }
}

/**
 * 小结
 * 	val user = User("zhangsan",11)，该语句在执行时，实际调用
 *    的是User伴生对象中的 apply 方法，因此不用new关键字就能构造出相应的对象。
 * 	当将User("zhangsan", 11)写在 case 后时[case User("zhangsan", 11) => "yes"]，
 *    会默认调用 unapply 方法(对象提取器)， user 作为 unapply 方法的参数，
 *    unapply 方法将 user 对象的 name 和 age 属性提取出来，与 User("zhangsan", 11)
 *    中的属性值进行匹配
 * 	case 中对象的 unapply方法(提取器)返回 Some，且所有属性均一致，才算匹配成功,
 *    属性不一致，或返回 None，则匹配失败。
 * 	若只提取对象的一个属性，则提取器为unapply(obj:Obj):Option[T]
 *    若提取对象的多个属性，则提取器为unapply(obj:Obj):Option[(T1,T2,T3…)]
 *   若提取对象的可变个属性，则提取器为unapplySeq(obj:Obj):Option[Seq[T]]
 *
 * 2）样例类
 * （1）语法：
 *    case class Person (name: String, age: Int)
 * （2）说明
 *    ① 样例类仍然是类，和普通类相比，只是其自动生成了伴生对象，并且伴生对象中自动提供了
 *      一些常用的方法，如apply、unapply、toString、equals、hashCode和copy。
 *    ② 样例类是为模式匹配而优化的类，因为其默认提供了unapply方法，因此，样例类可以
 *       直接使用模式匹配，而无需自己实现unapply方法。
 *    ③ 构造器中的每一个参数都成为val，除非它被显式地声明为var（不建议这样做）
 * （3）实操：见User112
 *    上述匹配对象的案例使用样例类会节省大量代码
 */
case class User112(name: String, age: Int)

object TestMatchUnapply1 {
  def main(args: Array[String]): Unit = {
    val user: User112 = User112("zhangsan", 11)
    val result: String = user match {
      case User112("zhangsan", 11) => "yes"
      case _ => "no"
    }
    println(result)
  }
}


object TestPatternMatching02 {

}

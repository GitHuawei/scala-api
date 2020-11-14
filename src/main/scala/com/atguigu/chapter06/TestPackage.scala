package com.atguigu.chapter06

/**
 * 6.1 Scala包
 *
 * 1）基本语法
 *    package 包名.类名
 *
 * 2）Scala包的三大作用（和Java一样）
 * （1）区分相同名字的类
 * （2）当类很多时，可以很好的管理类
 * （3）控制访问范围
 *
 * 6.1.1 包的命名
 *
 * 1）命名规则
 *    只能包含数字、字母、下划线、小圆点.，但不能用数字开头，也不要使用关键字。
 * 2）案例实操
 *    demo.class.exec1  //错误，因为 class 关键字
 *    demo.12a    //错误，数字开头
 * 3）命名规范
 *    一般是小写字母+小圆点
 *    com.公司名.项目名.业务模块名
 * 4）案例实操
 *    com.atguigu.oa.model
 *    com.atguigu.oa.controller
 *    com.sohu.bank.order
 *
 * 6.1.2 包说明（包语句）
 *
 * 1）说明
 *    Scala有两种包的管理风格，一种方式和Java的包管理风格相同，每个源文件一个包（包名和源文件所在路径
 *    不要求必须一致），包名用“.”进行分隔以表示包的层级关系，如com.atguigu.scala。另一种风格，通过
 *    嵌套的风格表示层级关系，如下：
 *              package com{
 *                  package atguigu{
 *                      package scala{
 *
 *                      }
 *                  }
 *              }
 *    第二种风格有以下特点：
 *      （1）一个源文件中可以声明多个package
 *      （2）子包中的类可以直接访问父包中的内容，而无需导包
 *
 *
 * 6.1.3 包对象
 *
 *  在Scala中可以为每个包定义一个同名的包对象，定义在包对象中的成员，作为其对应包下所有class和object
 *  的共享变量，可以被直接访问。
 *
 *  1）定义
 *      package object com {
 *          val shareValue = "share"
 *          def shareMethod() = {}
 *      }
 *  1）说明
 *    （1）若使用Java的包管理风格，则包对象一般定义在其对应包下的package.scala文件中，包对象名
 *        与包名保持一致。
 *    （2）如采用嵌套方式管理包，则包对象可与包定义在同一文件中，但是要保证包对象与包声明在同一作用域中。
 *
 *          package com {
 *              object Outer {
 *                  val out: String = "out"
 *                  def main(args: Array[String]): Unit = {
 *                        println(name)
 *                  }
 *             }
 *          }
 *
 *          package object com {
 *            val name: String = "com"
 *          }
 *
 * 6.1.4 导包说明
 * 1）和Java一样，可以在顶部使用import导入，在这个文件中的所有类都可以使用。
 * 2）局部导入：什么时候使用，什么时候导入。
 * 3）通配符导入：import java.util._
 * 4）给类起名：import java.util.{ArrayList=>JL}
 * 5）屏蔽类：import java.util.{ArrayList =>_,_}
 * 6）导入多个类：import java.util.{HashSet, ArrayList}
 * 7）导入包的绝对路径：new _root_.java.util.HashMap
 *      package java {
 *        package util {
 *          class HashMap {
 *          }
 *        }
 *      }
 *
 * 说明
 *    import com.atguigu.Fruit	引入com.atguigu包下Fruit（class和object）
 *    import com.atguigu._	引入com.atguigu下的所有成员
 *    import com.atguigu.Fruit._	引入Fruit(object)的所有成员
 *    import com.atguigu.{Fruit,Vegetable}	引入com.atguigu下的Fruit和Vegetable
 *    import com.atguigu.{Fruit=>Shuiguo}	引入com.atguigu包下的Fruit并更名为Shuiguo
 *    import com.atguigu.{Fruit=>Shuiguo,_}	引入com.atguigu包下的所有成员，并将Fruit更名为Shuiguo
 *    import com.atguigu.{Fruit=>_,_}	引入com.atguigu包下屏蔽Fruit类
 *    new _root_.java.util.HashMap	引入的Java的绝对路径
 * 导入包的绝对路径
 * 2）注意
 *    Scala中的三个默认导入分别是
 *    import java.lang._
 *    import scala._
 *    import scala.Predef._
 *
 * 6.1.5 访问权限
 *  1）说明
 *    在Java中，访问权限分为：public，private，protected和默认。在Scala中，你可以通过类似的修饰符
 *    达到同样的效果。但是使用上有区别。
 *    （1）Scala 中属性和方法的默认访问权限为public，但Scala中无public关键字。
 *    （2）private为私有权限，只在类的内部和伴生对象中可用。
 *    （3）protected为受保护权限，Scala中受保护权限比Java中更严格，同类、子类可以访问，同包无法访问。
 *    （4）private[包名]增加包访问权限，包名下的其他类也可以使用
 * 2）案例实操：见Person
 */

package com {

  import com.atguigu.Inner // 父包访问子包需要导包
  object Outer {
    var out: String = "out"

    def main(args: Array[String]): Unit = {
      println(Inner.in)
    }
  }

  package atguigu {

    object Inner {
      var in: String = "in"

      def main(args: Array[String]): Unit = {
        println(Outer.out) // 子包访问父包无需导包
      }
    }

  }

}

package other {

}

object TestPackage {

}


























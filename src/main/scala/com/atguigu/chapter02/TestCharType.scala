package com.atguigu.chapter02

/**
 * (1)字符串，通过+号连接
 * (2)printf用法：字符串，通过%传值。
 * (3)字符串模板：通过$获取变量值
 */
object TestCharType {

  def main(args: Array[String]): Unit = {

    var name: String = "jinlian"

    var age: Int = 18

    // 字符串，通过+号连接
    println(name + " " + age)

    // printf用法：字符串，通过%传值。
    printf("name=%s age=%d\n", name, age)

    var s: String =
      """
        |select
        |   name,
        |   age
        |from user
        |where name = "zhangsan"
        |""".stripMargin

    println(s)

    var s1 =
      s"""
         |select
         |   name,
         |   age
         |from user
         |where name="$name" and age=${age + 2}
         |""".stripMargin

    println(s1)

    var s2 = s"name=$name"
    println(s2)


    //（1）字符常量是用单引号 ' ' 括起来的单个字符。
    var c1: Char = 'a'
    println("c1=" + c1)

    //（2）\t ：一个制表位，实现对齐的功能
    println("姓名\t年龄")

    //（3）\n ：换行符
    println("西门庆\n潘金莲")

    //（4）\\ ：表示\
    println("c:\\岛国\\avi")

    //（5）\" ：表示"
    println("同学们都说：\"大海哥最帅\"")


  }

}

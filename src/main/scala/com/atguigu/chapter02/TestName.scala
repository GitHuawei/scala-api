package com.atguigu.chapter02

/**
 * Scala中的标识符声明，基本和Java是一致的，但是细节上会有所变化，有以下四种规则：
 *
 * 1、以字母或者下划线开头，后接字母、数字、下划线
 *
 * 2、以操作符开头，且只包含操作符（+ - * / # !等）
 *
 * 3、用反引号`....`包括的任意字符串，即使是Scala关键字（39个）也可以
 *
 * •	package, import, class, object, trait, extends, with, type, for
 * •	private, protected, abstract, sealed, final, implicit, lazy, override
 * •	try, catch, finally, throw
 * •	if, else, match, case, do, while, for, return, yield
 * •	def, val, var
 * •	this, super
 * •	new
 * •	true, false, null
 *
 */
object TestName {

  def main(args: Array[String]): Unit = {
    var hello: String = ""

    var hello12: String = ""

    //    var 1hello: String = "" // error数字不能开头

    //    var h-b: String = ""    // error 不能用-

    //    var x h: String = "" // error 不能有空格

    var h_4: String = "" // ok

    var _ab: String = "" // ok

    var Int: String = "" // ok 因为在Scala中Int是预定义的字符,不是关键字，但不推荐

    var _: String = "hello" // ok。但是单独一个下划线不可以作为标识符，因为_被认为是一个方法。

    var +-*/#! : String = "1111" // ok 以操作符开头，且只包含操作符（+ - * / # !等）

    println(+-*/#!)

    //    var if : String = "" // error 不能使用关键字
    var `if`: String = "" // ok 用反引号``包括的任意字符串，包括关键字，都能作为标识符


  }

}

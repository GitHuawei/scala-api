package com.atguigu.chapter02

/**
 * 数值类型和String类型间的转换
 */
object TestStringTransfer {

  def main(args: Array[String]): Unit = {
    // 1、基本类型转为String类型
    var str1: String = true.toString;
    var str2: String = false + ""
    var str3: String = 4.5.toString
    var str4: String = 4.5.+("")
    var str5: String = 100 + ""

    // 2、String类型转为基本类型
    var s1: Byte = "2".toByte
    var s2: Short = "3".toShort
    var s3: Int = "12".toInt
    var s4: Long = "123".toLong

    var s5: Boolean = "true".toBoolean
  }
}

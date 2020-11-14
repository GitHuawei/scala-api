package com.atguigu.chapter02

/**
 * 数值类型自动转换
 */
object TestValueTransfer {
  def main(args: Array[String]): Unit = {

    //（1）自动提升原则：有多种类型的数据混合运算时，系统首先自动将所有数据转换成精度大的那种数值
    //  类型，然后再进行计算。
    var n: Double = 1 + 2.0

    var n2: Double = 1.9
    //var n3 : Int = n2 //错误，原因不能把高精度的数据直接赋值和低精度。

    //（3）（byte，short）和char之间不会相互自动转换。
    var n4: Byte = 1
    //var c1 : Char = n4  //错误
    var n5: Int = n4

    var n6 : Byte = 1
    var c2 : Char = 1
     var result : Int = n6 + c2 //当n6 + c2 结果类型就是int
    // var n7 : Short = 10 + 90 //错误
  }
}

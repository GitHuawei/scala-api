package com.atguigu.chapter02

object TestDataType {

  def main(args: Array[String]): Unit = {

    var n1: Byte = 127
    var n2: Byte = -128

    //    var n3:Byte = 128 错误。Byte 的范围为 -128 到 127
    //    var n4:Byte = -129 错误。Byte 的范围为 -128 到 127

    var n5: Int = 10
    println(n5)

    var n6: Long = 9223372036854775807L
    println(n6)

    // 建议，在开发中需要高精度小数时，请选择Double
    var n7: Float = 2.2345678912f
    var n8: Double = 2.2345678912

    println("n7=" + n7)
    println("n8=" + n8)

  }

}

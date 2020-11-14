package com.atguigu.chapter05

/**
 * 递归
 */
object TestFunction11 {

  def main(array: Array[String]): Unit = {

    // 阶乘
    // 递归算法
    //1、方法调用自身
    //2、方法必须要有跳出的逻辑
    //3、方法调用自身时，传递的参数应该有规律
    //4、scala中的递归必须声明函数返回值类型
    println(test(5))

  }

  def test(i: Int): Int = {
    if (i == 1) {
      1
    } else {
      i * test(i - 1)
    }
  }
}

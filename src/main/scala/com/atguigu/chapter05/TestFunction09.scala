package com.atguigu.chapter05

/**
 * 高阶函数案例
 *
 * 需求：模拟Map映射、Filter过滤、Reduce聚合
 */
object TestFunction09 {

  def main(args: Array[String]): Unit = {

    //1、Map 映射
    def map(array: Array[Int], op: Int => Int) = {
      for (elem <- array) yield op(elem)
    }

    var arr = map(Array(1, 2, 3, 4), (x: Int) => {
      x * x
    })

    println(arr.mkString(","))


    //2、filter过滤
    def filter(array: Array[Int], op: Int => Boolean) = {
      for (elem <- array) yield op(elem)
    }

    filter(Array(1, 2, 3, 4), x => x % 2 == 1);

    var arr1 = filter(Array(1, 2, 3, 4), _ % 2 == 1)
    println(arr1.mkString(", "))


    //3、reduce聚合。有多个参数，且每个参数在后面只使用了一次，则参数省略且后面参数用_ 表示，第n个 _ 代表第n个参数
    def reduce(array: Array[Int], op: (Int, Int) => Int): Int = {
      var init: Int = array(0)

      for (elem <- 1 to (array.length)) {
        init = op(init, elem)
      }
      init
    }

    var arr2 = reduce(Array(1, 2, 3, 4, 5), (x, y) => x * y)
    var arr3 = reduce(Array(1, 2, 3, 4, 5), _ * _)
    println(arr2)
    println(arr3)
  }
}

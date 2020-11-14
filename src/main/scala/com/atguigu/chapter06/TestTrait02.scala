package com.atguigu.chapter06

/**
 * 6.7.3 特质叠加
 *    由于一个类可以混入（mixin）多个trait，且trait中可以有具体的属性和方法，若混入的特质中
 * 具有相同的方法（方法名，参数列表，返回值均相同），必然会出现继承冲突问题。冲突分为以下两种：
 *    第一种，一个类（Sub）混入的两个trait（TraitA，TraitB）中具有相同的具体方法，且两个
 * trait之间没有任何关系，解决这类冲突问题，直接在类（Sub）中重写冲突方法。
 *    第二种，一个类（Sub）混入的两个trait（TraitA，TraitB）中具有相同的具体方法，且两个
 * trait继承自相同的trait（TraitC），及所谓的“钻石问题”，解决这类冲突问题，Scala采用了特质叠加的策略。
 *
 * 所谓的特质叠加，就是将混入的多个trait中的冲突方法叠加起来，案例如下：
 */
object TestTrait02 {

  def main(args: Array[String]) : Unit = {
    println(new MyBall().describe())
  }

}

trait Ball {
  def describe(): String = {
    "ball"
  }
}

trait Color extends Ball {
  override def describe(): String = {
    "blue-" + super.describe()
  }
}

trait Category extends Ball {
  override def describe(): String = {
    "foot-" + super.describe()
  }
}

class MyBall extends Category with Color {
  override def describe(): String = {
    "my ball is a " + super.describe()
  } 
}

/**
 * 6.7.4 特质叠加执行顺序
 *    思考：上述案例中的super.describe()调用的是父trait中的方法吗？
 * 当一个类混入多个特质的时候，scala会对所有的特质及其父特质按照一定的顺序进行排序，而此案例中的
 * super.describe()调用的实际上是排好序后的下一个特质中的describe()方法。
 *
 *    结论：
 *（1）案例中的super，不是表示其父特质对象，而是表示上述叠加顺序中的下一个特质，即，MyClass中的super
 *    指代Color，Color中的super指代Category，Category中的super指代Ball。
 *（2）如果想要调用某个指定的混入特质中的方法，可以增加约束：super[]，例如
 *    super[Category].describe()。
 */

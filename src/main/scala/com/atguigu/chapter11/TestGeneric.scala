package com.atguigu.chapter11;

/**
 * 第11章 泛型
 *
 * 11.1 协变和逆变
 * 1）语法
 *    class MyList[+T]{ //协变
 *    }
 *
 *    class MyList[-T]{ //逆变
 *    }
 *
 *    class MyList[T] //不变
 *
 * 2）说明
 *  协变：Son 是 Father 的子类，则 MyList[Son] 也作为 MyList[Father]的“子类”。
 *  逆变：Son 是 Father 的子类，则 MyList[Son] 作为 MyList[Father] 的“父类”。
 *  不变：Son 是 Father 的子类，则 MyList[Father] 与 MyList[Son] “无父子关系”。
 * 3）实操如下
 */

abstract class Animal {
  var name: String
}

abstract class Pet extends Animal {

}

class Dog extends Pet {
  override var name: String = "dog"
}

class Cat extends Pet {
  override var name: String = "cat"
}

class Lion extends Animal {
  override var name: String = "lion"
}

class PetContainer[+P](val pet: P) {

}

object TestGeneric {
  def printer(petContainer: PetContainer[Pet]): Unit = {
    println(petContainer.pet.name)
  }

  def main(args: Array[String]): Unit = {
    val dog: Dog = new Dog()

    val cat: Cat = new Cat()

    val lion: Lion = new Lion()

    val dogContainer: PetContainer[Dog] = new PetContainer[Dog](dog)
    val catContainer: PetContainer[Cat] = new PetContainer[Cat](cat)

    printer(dogContainer)
    printer(catContainer)
  }
}

/**
 * 11.2 泛型上下限
 *  1）语法
 *    Class PersonList[T <: Person]{ //泛型上限
 *    }
 *    Class PersonList[T >: Person]{ //泛型下限
 *    }
 * 2）说明
 *    泛型的上下限的作用是对传入的泛型进行限定。
 * 3）实操如下
 */

class PetContainer1[P <: Pet](val pet: P) {

}

object TestGeneric1 {

  def printer(petContainer: PetContainer[Pet]): Unit = {
    println(petContainer.pet.name)
  }

  def main(args: Array[String]): Unit = {
    val dog: Dog = new Dog()
    val cat: Cat = new Cat()
    val lion: Lion = new Lion()

    val dogContainer: PetContainer1[Dog] = new PetContainer1[Dog](dog)
    val catContainer: PetContainer1[Cat] = new PetContainer1[Cat](cat)

    // error
    // val lionContainer: PetContainer1[Lion] = new PetContainer1[Lion](lion)

  }
}

/**
 * 11.3 上下文限定
 * 1）语法
 *    def f[A : B](a: A) = println(a) //等同于def f[A](a:A)(implicit arg:B[A])=println(a)
 * 2）说明
 *    上下文限定是将泛型和隐式转换的结合产物，以下两者功能相同，使用上下文限定[A : Ordering]之后，
 *    方法内无法使用隐式参数名调用隐式参数，需要通过implicitly[Ordering[A]]
 *    获取隐式变量。
 * 3）实操如下
 */

object TestGeneric3 {
  def main(args: Array[String]): Unit = {

    def f[A: Ordering](a: A, b: A): Int = implicitly[Ordering[A]].compare(a, b)

    def f[A](a: A, b: A)(implicit ord: Ordering[A]): Int = ord.compare(a, b)

  }
}

object TestTheGeneric {
}

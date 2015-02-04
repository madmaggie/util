package com.utils

/**
 * Created by Rox on 04.02.2015.
 *
 * Links
 *  https://bcomposes.wordpress.com/2011/08/20/fun-with-function-composition-in-scala/
 *
 */
object Composition {

  private var myInputList: List[Int] = List(1, 2, 3, 4, 5)

  val add_1 = (x: Int) => x + 1
  val add_100 = (x: Int) => x + 100
  val square = (x: Int) => x * x



  def main (args: Array[String]): Unit = {
    println("Welcome to composing functions")
    println(myInputList map add_1)
    println(myInputList map add_100)
    println(myInputList map square)

    // Saving intermediate result
    val intermediaryResult = myInputList map square
    intermediaryResult map square

    // You can compose as many functions as you want
    println(myInputList map add_1 map add_100 map square)
  }
}

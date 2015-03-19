package org.bescala

object MaybeApp extends App {

  case class Person(name: String, age: Int)
  val maybeName = Maybe("John")
  val maybeAge = Maybe(30)

  // filtering, flatMap and map
  val maybePerson =
    maybeName.filter(_.length >= 4).flatMap { name =>
      maybeAge.map { age =>
        Person(name, age)
      }
    }
  println("func -> " + maybePerson)


  // using for comprehension
  val maybePersonFor =
    for {
      name <- maybeName if name.length >= 4
      age <- maybeAge
    } yield Person(name, age)
  println("for -> " + maybePersonFor)

}

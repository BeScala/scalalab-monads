package org.bescala

object MaybeApp extends App {

  case class Address(street:String)
  case class Person(name:String, age:Int, address:Address)

  val maybeName = Maybe("John")
  val maybeAge = Maybe(30)
  val maybeAddress = Maybe(Address("Sesamestraat"))

  // NOTE:
  // you can only construct a Person if you have the 'name', the 'age' and the 'address'.


  // pure functional example
  // filtering, flatMap and map
  val maybePerson =
    maybeName.filter(_.length >= 4).flatMap { name =>
      maybeAge.flatMap { age =>
        maybeAddress.map { address =>
          // if all the Maybes have a valid value all functions are called
          // and we end at the 'map' method where we can construct our Person
          Person(name, age, address)
        }
      }
    }
  println("func -> " + maybePerson)


  // same code using for-comprehension syntax sugar
  val maybePersonFor =
    for {
      name <- maybeName if name.length >= 4
      age <- maybeAge
      address <- maybeAddress
    } yield Person(name, age, address)

  println("for -> " + maybePersonFor)

}

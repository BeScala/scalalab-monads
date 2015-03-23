package org.bescala

object MaybeApp extends App {

  case class Address(street:String)
  case class Person(name:String, age:Int, address:Address)

  // play around with these value
  // replace each of them by a Maybe.empty
  val maybeName: Maybe[String] = Maybe("John")
  val maybeAge: Maybe[Int] =  Maybe(30)
  val maybeAddress:Maybe[Address] = Maybe(Address("Sesamestraat"))

  // NOTE:
  // you can only construct a Person if you have the 'name', the 'age' and the 'address'.


  println("------------------------------------------")
  println("Pure functional example using filtering, flatMap and map")
  println()
  val maybePerson =
    maybeName.filter(_.length >= 4).flatMap { name =>
      println(s"--> prints $name if not empty")
      maybeAge.flatMap { age =>
        println(s"--> prints $age if not empty")
        maybeAddress.map { address =>
          println(s"--> prints $address if not empty")
          // if all the Maybes have a valid value all functions are called
          // and we end at the 'map' method where we can construct our Person
          Person(name, age, address)
        }
      }
    }
  println("func -> " + maybePerson)
  println("------------------------------------------")

  println()

  println("------------------------------------------")
  println("same but using for-comprehension syntax sugar")
  println("(not without printlns in between)")
  println()
  val maybePersonFor =
    for {
      name <- maybeName if name.length >= 4
      age <- maybeAge
      address <- maybeAddress
    } yield Person(name, age, address)

  println("for -> " + maybePersonFor)
  println("------------------------------------------")
}

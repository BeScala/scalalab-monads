package org.bescala

import org.scalatest.FlatSpec

class MaybeCovarianceTest extends FlatSpec {

  trait Animal {
    def name: String
  }
  case class Cat(name: String) extends Animal
  case class Dog(name: String) extends Animal

  behavior of "'Maybe'"

  it must "be covariant on its value" in {

    val aCatInABox = Maybe(Cat("Schrödinger's Cat"))
    val aDogInABox = Maybe(Dog("Tom, the dog"))

    acceptAnimal(aCatInABox)
    acceptAnimal(aDogInABox)
    acceptAnimal(Maybe.empty)

  }

  def acceptAnimal(animalBox: Maybe[Animal]) = {
    println("Open it to kill what is inside!")
  }


}

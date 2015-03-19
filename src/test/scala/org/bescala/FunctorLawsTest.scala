package org.bescala

import org.scalatest.{Matchers, FlatSpec}

class FunctorLawsTest extends FlatSpec with Matchers  {

  behavior of "'Maybe' as a Functor"

  /**
   * The first functor law states that if we map the id function over a functor,
   * the functor that we get back should be the same as the original functor.
   *
   * From "Learn you a Haskell for great good!"
   * http://learnyouahaskell.com/
   */
  it should "abide to first Functor law" in {
    val maybeAbc = Maybe("abc")

    maybeAbc.map(identity) shouldEqual maybeAbc
  }


  /**
   * The second law says that composing two functions and then mapping the resulting function
   * over a functor should be the same as first mapping one function over the functor
   * and then mapping the other one.
   *
   * From "Learn you a Haskell for great good!"
   * http://learnyouahaskell.com/
   */
  it should "abide to second Functor law" in {
    val taggingFunc = (text:String) => s"<tag>$text</tag>"
    val lengthFunc = (text:String) => text.length

    // lengthFunc(taggingFunc("something"))
    val composed = lengthFunc compose taggingFunc

    val maybeAbc = Maybe("abc")

    val result1 = maybeAbc.map(composed)
    val result2 = maybeAbc.map(taggingFunc).map(lengthFunc)

    result1 shouldEqual result2
  }
}

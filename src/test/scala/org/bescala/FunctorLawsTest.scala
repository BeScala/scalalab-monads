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
  it should "abide to first Functor law" in pending


  /**
   * The second law says that composing two functions and then mapping the resulting function
   * over a functor should be the same as first mapping one function over the functor
   * and then mapping the other one.
   *
   * From "Learn you a Haskell for great good!"
   * http://learnyouahaskell.com/
   */
  it should "abide to second Functor law" in pending
}

package org.bescala

import org.scalatest.{FunSuite, Matchers, FlatSpec}

class MonadLawsTest extends FlatSpec with Matchers  {

  behavior of "'Maybe'"


  /**
   * The first monad law states that if we take a value,
   * put it in a default context with `Monad.apply`
   * and then feed it to a function by using `flatMap`,
   * it’s the same as just taking the value and applying the function to it.
   *
   * Adapted to Scala idiom from "Learn you a Haskell for great good!"
   * http://learnyouahaskell.com/
   *
   * ie: proves that `flatMap` method does NOT alter the value
   */
  it must "abide to the left identity law" in pending

  /**
   * The second law states that if we have a monadic value and
   * we use `flatMap` to feed it to `Monad.apply`, the result is our original monadic value.
   *
   * Adapted to Scala idiom from "Learn you a Haskell for great good!"
   * http://learnyouahaskell.com/
   *
   * ie: proves that `apply` method does NOT alter the value
   */
  it must " must abide to the right identity law" in pending


  /**
   * The final monad law says that when we have a chain of monadic
   * function applications with `flatMap`, it shouldn’t matter how they’re nested.
   *
   * Adapted to Scala idiom from "Learn you a Haskell for great good!"
   * http://learnyouahaskell.com/
   *
   */
  it must " must abide to the associativity law" in pending

}

package org.bescala

import org.scalatest.{Matchers, FlatSpec}

class MonadLawsTest extends FlatSpec with Matchers  {

  behavior of "'Maybe' as a Monad"


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
  it must "abide to the left identity monad law" in {
    val abc = "abc"

    // a function from String to Maybe[String]
    // (text:String) => Maybe[String]
    val taggingFunc = (text:String) => Maybe(s"<tag>$text</tag>")

    (Maybe(abc) flatMap taggingFunc) shouldEqual taggingFunc(abc)


    // another function from String to Maybe[Int]
    // (text:String) => Maybe[Int]
    val lengthFunc = (text:String) => Maybe(text.length)
    (Maybe(abc) flatMap lengthFunc) shouldEqual lengthFunc(abc)
  }

  /**
   * The second law states that if we have a monadic value and
   * we use `flatMap` to feed it to `Monad.apply`, the result is our original monadic value.
   *
   * Adapted to Scala idiom from "Learn you a Haskell for great good!"
   * http://learnyouahaskell.com/
   *
   * ie: proves that `apply` method does NOT alter the value
   */
  it must " must abide to the right identity monad law" in {
    val maybeAbc = Maybe("abc")

    maybeAbc.flatMap(Maybe(_)) shouldEqual maybeAbc
  }


  /**
   * The final monad law says that when we have a chain of monadic
   * function applications with `flatMap`, it shouldn’t matter how they’re nested.
   *
   * Adapted to Scala idiom from "Learn you a Haskell for great good!"
   * http://learnyouahaskell.com/
   *
   */
  it must " must abide to the associativity monad law" in {
    
    val taggingFunc = (text:String) => Maybe(s"<tag>$text</tag>")
    val lengthFunc = (text:String) => Maybe(text.length)

    // (m flatMap f) flatMap g
    val result1 = Maybe("abc") flatMap taggingFunc flatMap lengthFunc

    // m flatMap { x => f(x) flatMap {g} }
    val result2 = Maybe("abc").flatMap( v => taggingFunc(v).flatMap(lengthFunc) )

    result1 shouldEqual result2
  }

}

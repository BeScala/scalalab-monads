package org.bescala

import org.scalacheck.{Arbitrary, Gen}

import scalaz._

object ScalazChecks {

  implicit val maybeArbitraryInt = Arbitrary(Gen.choose(0, 100).map(Maybe(_)))

  implicit val maybeArbitraryInt2MaybeInt =
    Arbitrary(Gen.choose(0, 100).map { i =>
      (i: Int) => Maybe(i)
    })

  implicit val maybeArbitraryMaybeInt2Int =
    Arbitrary(Gen.choose(0, 100).map { i =>
      Maybe((i: Int) => i)
    })

  implicit val maybeEqual = new Equal[Maybe[Int]] {
    override def equal(a1: Maybe[Int], a2: Maybe[Int]): Boolean = a1 == a2
  }

  implicit val maybeMonad = new Monad[Maybe] {
    override def point[A](a: => A): Maybe[A] = Maybe(a)

    override def bind[A, B](fa: Maybe[A])(f: (A) => Maybe[B]): Maybe[B] = fa.flatMap(f)
  }

  implicit val maybeFunctor = new Functor[Maybe] {
    override def map[A, B](fa: Maybe[A])(f: (A) => B): Maybe[B] = fa.map(f)
  }
}

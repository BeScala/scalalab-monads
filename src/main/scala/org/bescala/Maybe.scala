package org.bescala

sealed trait Maybe[+A] {
  def flatMap[B](f: A => Maybe[B]): Maybe[B]
  def map[B](f: A => B): Maybe[B]
}

object Maybe {
  def apply[A](value: A): Maybe[A] = {
    if (value != null) Just(value)
    else Empty
  }

  def empty: Empty.type = Empty
}

case class Just[+A](value: A) extends Maybe[A] {
  def flatMap[B](f: (A) => Maybe[B]): Maybe[B] = f(value)

  def map[B](f: (A) => B): Maybe[B] = Maybe(f(value))
}

case object Empty extends Maybe[Nothing] {
  def flatMap[B](f: (Nothing) => Maybe[B]): Maybe[B] = Empty

  def map[B](f: (Nothing) => B): Maybe[B] = Empty
}

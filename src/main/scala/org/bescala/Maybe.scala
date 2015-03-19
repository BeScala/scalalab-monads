package org.bescala

sealed trait Maybe[+A] {

  def flatMap[B](f: A => Maybe[B]): Maybe[B]

  def map[B](f: A => B): Maybe[B]

  def filter(f: A => Boolean): Maybe[A]

  def get: A
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

  def filter(f: (A) => Boolean): Maybe[A] = if (f(value)) this else Empty

  def get: A = value
}

case object Empty extends Maybe[Nothing] {

  def flatMap[B](f: (Nothing) => Maybe[B]): Maybe[B] = Empty

  def map[B](f: (Nothing) => B): Maybe[B] = Empty

  def filter(f: (Nothing) => Boolean): Maybe[Nothing] = Empty

  def get: Nothing = throw new NoSuchElementException("Empty.get")
}

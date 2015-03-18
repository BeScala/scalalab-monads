package org.bescala

import java.util.NoSuchElementException

sealed trait Maybe[+A]

object Maybe {
  def apply[A](value: A): Maybe[A] = {
    if (value != null) Just(value)
    else Empty
  }

  def empty : Empty.type = Empty
}

case class Just[+A](value: A) extends Maybe[A]

case object Empty extends Maybe[Nothing]

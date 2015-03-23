package org.bescala.alter

import java.util.NoSuchElementException


/**
 * Alternative Maybe implementation with almost all functionality defined in the trait itself.
 *
 * (very similar to Scala's Option type)
 * 
 */
trait Maybe[+A] {

  def get: A
  def isDefined: Boolean

  def isEmpty: Boolean = !isDefined

  def flatMap[B](func: A => Maybe[B]): Maybe[B] =
    if (isDefined) func(get) else Empty

  def map[B](func: A => B): Maybe[B] =
    if (isEmpty) Maybe(func(get)) else Empty

  def filter(predicate: A => Boolean): Maybe[A] =
    if (isDefined && predicate(this.get)) this else Empty

}

object Maybe {
  def apply[A](value: A): Maybe[A] = {
    if (value != null) Just(value)
    else Empty
  }

  def empty: Empty.type = Empty
}

case class Just[+A](value: A) extends Maybe[A] {
  /** Just always have a value */
  override def isDefined: Boolean = true

  /** Just always return its value */
  override def get: A = value
}

case object Empty extends Maybe[Nothing] {
  /** Empty never has a value */
  override def isDefined: Boolean = false

  /** Empty.get always throws NoSuchElementException  */
  override def get: Nothing = throw new NoSuchElementException("Empty.get")
}
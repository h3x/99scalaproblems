package problems

import scala.annotation.tailrec

object NinetyNine {

  // Find the last element of a list.
  @tailrec
  def lastElement[T](list:List[T]):T ={
    list match {
      case h :: Nil => h
      case _ :: tail => lastElement(tail)
      case _ => throw new NoSuchElementException
    }
  }

  // Find the last but one element of a list.
  def secondLastElement[T](list:List[T]):T ={
    ???
  }

  // Find the Kth element of a list.
  def kthElement[T](list:List[T], element:Int):T ={
    ???
  }

  // Find the number of elements of a list.
  def listLength[T](list:List[T]):Int ={
    ???
  }

  // Reverse a list.
  def reverseList[T](list:List[T]):List[T] ={
    ???
  }

  // Find out whether a list is a palindrome.
  def isPalindrome[T](list:List[T]):Boolean ={
    ???
  }

  // Flatten a nested list structure.
  def flatenList[T](list:List[T]):List[Any]={
    ???
  }

  // Eliminate consecutive duplicates of list elements.
  // If a list contains repeated elements they should be replaced with a single copy of the element.
  // The order of the elements should not be changed.
  def noConsecutiveDupes[T](list:List[T]):List[T]={
    ???
  }

  // Pack consecutive duplicates of list elements into sublists.
  // If a list contains repeated elements they should be placed in separate sublists.
  def dupePacker[T](list:List[T]):List[List[T]] ={
    ???
  }

  // Run-length encoding of a list.
  // Use the result of dupePacker to implement the so-called run-length encoding data compression method.
  // Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
  def encode[T](list:List[T]):List[(Int, T)] ={
    ???
  }

  // Modified run-length encoding
  // Modify the result of encode in such a way that if an element has no duplicates it is simply
  // copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
  def modifiedEncode[T](list:List[T]):List[Any] ={
    ???
  }


}

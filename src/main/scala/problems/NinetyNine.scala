package problems

import scala.annotation.tailrec

object NinetyNine {

  @tailrec
  def lastElement[T](list:List[T]):T ={
    list match {
      case h :: Nil => h
      case _ :: tail => lastElement(tail)
      case _ => throw new NoSuchElementException
    }
  }


  def secondLastElement[T](list:List[T]):T ={
    ???
  }

  def kthElement[T](list:List[T], element:Int):T ={
    ???
  }


}

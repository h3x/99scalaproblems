package problems

import scala.annotation.tailrec

object NinetyNine {

  // Find the last element of a list.
  def lastElement[T](list:List[T]):T ={
    list.last
  }

  // Find the last but one element of a list.
  def secondLastElement[T](list:List[T]):T ={
    val (result,_) = list.zipWithIndex.filter({ case(x,i) => i ==list.length-2}).head
    result
  }

  // Find the Kth element of a list.
  def kthElement[T](list:List[T], element:Int):T ={
    val (result,_) = list.zipWithIndex.filter({ case(x,i) => i ==element}).head
    result
  }

  // Find the number of elements of a list.
  def listLength[T](list:List[T]):Int ={
    list.length
  }

  // Reverse a list.
  def reverseList[T](list:List[T]):List[T] ={
    list.reverse
  }

  // Find out whether a list is a palindrome.
  def isPalindrome[T](list:List[T]):Boolean ={
    list == list.reverse
  }

  // Flatten a nested list structure.
  def flatenList[T](list:List[T]):List[T]={
    list.flatMap({ x =>
      x match {
        case x:List[T] => x
        case x => List(x)
      }
    })
  }

  // Eliminate consecutive duplicates of list elements.
  // If a list contains repeated elements they should be replaced with a single copy of the element.
  // The order of the elements should not be changed.
  def noConsecutiveDupes[T](list:List[T]):List[T]={
    list.foldLeft(List():List[T])({
    case (previous, element) if previous.isEmpty || previous.last != element => previous:::List(element)
    case (previous, element) => previous
    })
  }

  // Pack consecutive duplicates of list elements into sublists.
  // If a list contains repeated elements they should be placed in separate sublists.
  def dupePacker[T](list:List[T]):List[List[T]] ={
    if (list.isEmpty) List(List())
    else {
      val(packed, next) = list span (_ == list.head)
      if (next == Nil) List(packed)
      else packed :: dupePacker(next)
    }
  }

  // Run-length encoding of a list.
  // Use the result of dupePacker to implement the so-called run-length encoding data compression method.
  // Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
  def encode[T](list:List[T]):List[(Int, T)] ={
    def helper(l:List[List[T]]):List[(Int, T)] ={
      val(head, tail) =(l.head, l.tail)
      if (tail == Nil) List((head.length, head.head))
      else (head.length, head.head) :: helper(tail)
    }
    helper(dupePacker(list))
  }

  // Modified run-length encoding
  // Modify the result of encode in such a way that if an element has no duplicates it is simply
  // copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
  def modifiedEncode[T](list:List[T]):List[Any] ={
    def helper(l:List[List[T]]):List[Any] ={
      val(head, tail) =(l.head, l.tail)
      if (tail == Nil) List((head.length, head.head))
      else {
        if (head.length > 1) (head.length, head.head) :: helper(tail)
        else head.head :: helper(tail)
      }
    }
    helper(dupePacker(list))
  }

  // Given a run-length code list generated as specified in problem 'encode', construct its uncompressed version
  def decode[T](list:List[(Int, T)]):List[Any] = {
    flatenList(for( (num,l) <- list ) yield List.fill(num)(l))
  }

  ///Implement the so-called run-length encoding data compression method directly.
  // I.e. don't use other methods you've written above; do all the work directly
  def encodeDirect[T](list:List[T]):List[(Int, T)] = {
    def encoder(l:List[T]):List[(Int, T)] = {
      val (h, t) = l.span(_ == l.head)
      if (t.isEmpty) List((h.length, h.head))
      else List((h.length, h.head)) ::: encoder(t)
    }
    encoder(list)
  }

  //Duplicate the elements of a list num times.
  def dupe[T](num: Int, list:List[T]):List[Any] = {
    list.flatMap({ x=> List.fill(num)(x) })
  }

  // Drop every Nth element from a list.
  def drop[T](num:Int, list:List[T]): List[T] = {
    val (l, _) = list.zipWithIndex.filter({case(e,n) => n % num != num-1 }).unzip
    l
  }

  // Split a list into two parts at num
  def split[T](num:Int, list:List[T]):(List[T], List[T]) = {
    list.splitAt(num)
  }

  // Given two indices, I and K, the slice is the list containing the elements from and including the Ith element
  // up to but not including the Kth element of the original list. Start counting the elements with 0.
  def listSlice[T](I:Int, K:Int, list:List[T]):List[T] = {
    val (l1, _) = list.splitAt(K)
    val(_, l2) = l1.splitAt(I)
    l2
  }

  // Rotate a list N places to the left.
  def rotate[T](n:Int, list:List[T]):List[T] = {
    val(l1, l2) =
      if (n < 0) list.splitAt(list.length - Math.abs(n))
      else list.splitAt(n)
    l2 ::: l1
  }

  // Return the list and the removed element in a Tuple. Elements are numbered from 0
  def removeAt[T](n:Int, list:List[T]):(List[T], T) ={
    val( l1, l2) = list.splitAt(n+1)
    val el = l1.last
    val(l5,l6) = l1.splitAt(l1.length-1)
    (l5 ::: l2, l6.head)
  }

  //  Insert an element at a given position into a list.
  def insertAt[T](element:T, n:Int, list:List[T]):List[T] = {
    val(l1,l2) = list.splitAt(n)
    l1 ::: List(element) ::: l2
  }

  // Create a list containing all integers within a given range.
  def _range(i:Int, j:Int):List[Int] = {
    ???
  }

  //  Extract a given number of randomly selected elements from a list.
  def randomSelect[T](n:Int, list:List[T]):List[T] = {
    ???
  }

  //Draw N different random numbers from the set 1..M.
  def lotto(n:Int, m:Int):List[Int]= {
    ???
  }

  // Generate a random permutation of the elements of a list.
  def randomPermute[T](list:List[T]):List[T] = {
    ???
  }

  // Generate the combinations of K distinct objects chosen from the N elements of a list.
  // In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there are C(12,3) = 220
  // possibilities (C(N,K) denotes the well-known binomial coefficient). For pure mathematicians, this result may be great.
  // But we want to really generate all the possibilities
  def combos[T](n:Int, list:List[T]):List[List[T]] ={
    ???
  }




}

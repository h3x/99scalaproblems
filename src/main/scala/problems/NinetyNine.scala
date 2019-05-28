package problems

import scala.annotation.tailrec

object NinetyNine {

  // Find the last element of a list.

  def lastElement[T](list:List[T]):T ={
    ???
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

  // Given a run-length code list generated as specified in problem 'encode', construct its uncompressed version
  def decode[T](list:List[(Int, T)]):List[T] = {
    ???
  }

  ///Implement the so-called run-length encoding data compression method directly.
  // I.e. don't use other methods you've written above; do all the work directly
  def encodeDirect[T](list:List[T]):List[(Int, T)] = {
    ???
  }

  //Duplicate the elements of a list num times.
  def dupe[T](num: Int, list:List[T]):List[T] = {
    ???

  }

  // Drop every Nth element from a list.
  def drop[T](num:Int, list:List[T]): List[T] = {
    ???
  }

  // Split a list into two parts at num
  def split[T](num:Int, list:List[T]):(List[T], List[T]) = {
    ???
  }

  // Given two indices, I and K, the slice is the list containing the elements from and including the Ith element
  // up to but not including the Kth element of the original list. Start counting the elements with 0.
  def listSlice[T](I:Int, K:Int, list:List[T]):List[T] = {
    ???
  }

  // Rotate a list N places to the left.
  def rotate[T](n:Int, list:List[T]):List[T] = {
    ???
  }

  // Return the list and the removed element in a Tuple. Elements are numbered from 0
  def removeAt[T](n:Int, list:List[T]):(List[T], T) ={
    ???
  }

  //  Insert an element at a given position into a list.
  def insertAt[T](element:T, n:Int, list:List[T]):List[T] = {
    ???
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

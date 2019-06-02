package problems

import org.scalatest._

class NinetyNineSpec extends FlatSpec with Matchers {

  import NinetyNine._

  "lastElement" should "return the last element of a list" in {
    lastElement(List(1,2,3,4,5)) should be (5)
    lastElement(('a' to 'z').toList) should be ('z')
    lastElement(List("adam","austin","is","no","good")) should be ("good")

    assertThrows[NoSuchElementException] {
      lastElement(List())
    }
  }

  "secondLastElement" should "return the second last element in a list" in {
    secondLastElement((1 to 10).toList) should be(9)
    secondLastElement(('a' to 'z').toList) should be('y')
    secondLastElement(List("adam", "austin", "is", "no", "good")) should be("no")

    assertThrows[NoSuchElementException] {
      secondLastElement(List())
    }
  }

  "kthElement" should "return the kth element from a list" in {
    kthElement((1 to 10).toList, 4) should be (5)
    kthElement(('a' to 'z').toList, 7) should be ('h')

    assertThrows[NoSuchElementException] {
      kthElement(List(), 0)
    }
  }

  "listLength" should "return the length of a list" in {
    listLength((1 to 10).toList) should be (10)
    listLength(('a' to 'z').toList) should be (26)
    listLength(List()) should be (0)
    listLength(List(('a' to 'z').toList, (1 to 10).toList)) should be (2)
  }

  "reverseList" should "return a list with elements reversed" in {
    reverseList((1 to 10).toList) should be (List(10,9,8,7,6,5,4,3,2,1))
    reverseList(List('a', 'b', 'c')) should be (List('c', 'b', 'a'))
    reverseList(List(List('a', 'b'), List(1 , 2, 3))) should be (List(List(1,2,3), List('a', 'b')))
    reverseList(List()) should be (List())

  }

  "isPalindrome" should "Find out whether a list is a palindrome." in {
    isPalindrome((1 to 10).toList) should be (false)
    isPalindrome(List(1,2,3,3,2,1)) should be (true)
    isPalindrome(List(1,2,3,4,3,2,1)) should be (true)
    isPalindrome(List('r','a','c','e','c','a','r')) should be (true)
  }

  "flatenList" should "Flatten a nested list structure." in {
    flatenList(List(List(1,2),List(3,4),List(5,6),List(7,8))) should be (List(1,2,3,4,5,6,7,8))
  }

  "noConsecutiveDupes" should "Eliminate consecutive duplicates of list elements." in {
    noConsecutiveDupes(List(1,1,2,3,4,5,4,5,5,5,6,7,8,8,8,8)) should be (List(1,2,3,4,5,4,5,6,7,8))
  }

  "dupePacker" should "Pack consecutive duplicates of list elements into sublists." in {
    dupePacker(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')) should be (List(List('a', 'a', 'a', 'a'), List('b'), List('c', 'c'), List('a', 'a'), List('d'), List('e', 'e', 'e', 'e')))
  }

  "encode" should "Run-length encoding of a list." in {
    encode(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')) should be (List((4,'a'), (1,'b'), (2,'c'), (2,'a'), (1,'d'), (4,'e')))
  }

  "modifiedEncode" should "Modified run-length encoding" in {
    modifiedEncode(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')) should be (List((4,'a'), 'b, (2,'c'), (2,'a'), 'd', (4,'e')))
  }

  "decode" should "Given a run-length code list generated as specified in problem 'encode', construct its uncompressed version" in {
    decode(List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e'))) should be  (List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
  }

  "dupe" should "Duplicate the elements of a list num times." in {
    dupe(2,List('a', 'b', 'c', 'c', 'd')) should be (List('a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd', 'd'))
  }

  "drop" should "Drop every Nth element from a list" in {
    drop(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')) should be  (List('a', 'b', 'd', 'e', 'g', 'h', 'j', 'k'))
  }

  "split" should "Split a list into two parts at num" in {
    split(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')) should be ((List('a', 'b', 'c'),List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))
  }

  "listSlice" should "slice a list from i to j" in {
    listSlice(3, 7, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')) should be (List('d', 'e', 'f', 'g'))
  }

  "rotate" should "Rotate a list N places to the left." in {
    rotate(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')) should be (List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'a', 'b', 'c'))
    rotate(-2, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')) should be (List('j', 'k', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'))
  }

  "removeAt" should "Return the list and the removed element in a Tuple. Elements are numbered from 0" in {
    removeAt(1, List('a', 'b', 'c', 'd')) should be ((List('a', 'c', 'd'),'b'))
  }

  "insertAt" should "Insert an element at a given position into a list" in {
    insertAt("new", 1, List('a', 'b', 'c', 'd')) should be (List('a', "new", 'b', 'c', 'd'))
  }

  "_range" should "Create a list containing all integers within a given range." in {
    _range(4, 9) should be (List(4, 5, 6, 7, 8, 9))
  }

  "combinations" should "Generate the combinations of K distinct objects chosen from the N elements of a list" in {
    val c1 = combos(1, List('a','b','c'))
    val a1 = List(List('a'), List('b'), List('c'))
    assert(c1.length == a1.length && c1.toSet == a1.toSet)

    val c2 = combos(2, List('a','b','c'))
    val a2 = List(List('a', 'b'), List('a', 'c'), List('b', 'c'))
    assert(c2.length == a2.length && c2.toSet == a2.toSet)

    val c3 = combos(3, List('a', 'b', 'c', 'd', 'e' , 'f'))
    val a3 = List(List('a', 'b', 'c'), List('a', 'b', 'd'), List('a',
      'b', 'e'), List('a', 'b', 'f'), List('a', 'c', 'd'), List('a', 'c', 'e'), List('a', 'c',
      'f'), List('a', 'd', 'e'), List('a', 'd', 'f'), List('a', 'e', 'f'), List('b', 'c', 'd')
      , List('b', 'c', 'e'), List('b', 'c', 'f'), List('b', 'd', 'e'), List('b', 'd', 'f'), List
      ('b' , 'e', 'f'), List('c', 'd', 'e'), List('c', 'd', 'f'), List('c', 'e', 'f'), List(
        'd', 'e', 'f'))
    assert(c3.length == a3.length && c3.toSet == a3.toSet)
  }

}


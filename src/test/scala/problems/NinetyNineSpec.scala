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
    kthElement((1 to 10).toList, 4) should be (3)
    kthElement(('a' to 'z').toList, 7) should be ('f')

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
    dupePacker(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be (List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }

  "encode" should "Run-length encoding of a list." in {
    encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be (List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }

  "modifiedEncode" should "Modified run-length encoding" in {
    modifiedEncode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be (List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))
  }


}


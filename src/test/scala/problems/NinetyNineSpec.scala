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
    secondLastElement((1 to 10).toList) should be (9)
    secondLastElement(('a' to 'z').toList) should be ('y')
    secondLastElement(List("adam", "austin", "is", "no", "good")) should be ("no")

    assertThrows[NoSuchElementException] {
      secondLastElement(List())
    }

    "kthElement" should "return the kth element from a list" in {
      kthElement((1 to 10).toList, 4) should be (3)
      kthElement(('a' to 'z').toList, 7) should be ('f')

      assertThrows[NoSuchElementException] {
        kthElement(List(), 1)
      }

    }
  }



}

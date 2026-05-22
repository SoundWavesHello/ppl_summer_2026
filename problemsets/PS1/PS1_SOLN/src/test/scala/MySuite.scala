import scala.math.round

class MySuite extends munit.FunSuite {

  test("outputConsecutivePairsTest1") {
    val lst1 = List((1,1), (-1, 1), (1, -1))
    assertEquals(outputConsecutivePairs(lst1), List((1, 1)))
  }

  test("outputConsecutivePairsTest2") {
    val lst2 = List((1, 2), (2, 1), (1,0), (0,1), (1,1))
    assertEquals(outputConsecutivePairs(lst2), lst2)
  }

  test("outputConsecutivePairsTest3") {
    val lst3 = List((1,5), (5,1))
    assertEquals(outputConsecutivePairs(lst3), Nil)
  }

  test("outputConsecutivePairsTest4") {
    val lst4 = List((2,5), (1,2), (-5, -4), (4,1))
    assertEquals(outputConsecutivePairs(lst4), List((1,2), (-5,-4)))
  }
  
  test("outputConsecutivePairsRecTest1") {
    val lst1 = List((1,1), (-1, 1), (1, -1))
    assertEquals(outputConsecutivePairsRec(lst1), List( (1,1)))
  }

  test("outputConsecutivePairsRecTest2") {
    val lst2 = List((1, 2), (2, 1), (1,0), (0,1), (1,1))
    assertEquals(outputConsecutivePairsRec(lst2), lst2)
  }

  test("outputConsecutivePairsRecTest3") {
    val lst3 = List((1,5), (5,1))
    assertEquals(outputConsecutivePairsRec(lst3), Nil)
  }

  test("outputConsecutivePairsRecTest4") {
    val lst4 = List((2,5), (1,2), (-5, -4), (4,1))
    assertEquals(outputConsecutivePairsRec(lst4), List((1,2), (-5,-4)))
  }

  test("logTenFloorTest1") {
    intercept[IllegalArgumentException] {
      logTenFloor(0)
    }
  }

  test("logTenFloorTest2") {
    intercept[IllegalArgumentException] {
      logTenFloor(-10)
    }
  }

  test("logTenFloorTest3") {
    assertEquals(logTenFloor(1), 0)
    assertEquals(logTenFloor(9), 0)
  }

  test("logTenFloorTest4") {
    assertEquals(logTenFloor(10), 1)
    assertEquals(logTenFloor(11), 1)
  }

  test("logTenFloorTailTest1") {
    intercept[IllegalArgumentException] {
      logTenFloorTail(0)
    }
  }

  test("logTenFloorTailTest2") {
    intercept[IllegalArgumentException] {
      logTenFloorTail(-200000)
    }
  }

  test("logTenFloorTailTest3") {
    assertEquals(logTenFloorTail(2), 0)
    assertEquals(logTenFloorTail(7), 0)
  }

  test("logTenFloorTailTest4") {
    assertEquals(logTenFloorTail(9), 0)
    assertEquals(logTenFloorTail(10), 1)
    assertEquals(logTenFloorTail(11), 1)
    assertEquals(logTenFloorTail(15), 1)
    assertEquals(logTenFloorTail(99), 1)
    assertEquals(logTenFloorTail(100), 2)
    assertEquals(logTenFloorTail(101), 2)
    assertEquals(logTenFloorTail(159), 2)
  }

  test("logTenFloorTailTest5") {
    assertEquals(logTenFloorTail(121349), 5)
  }
  
  test("listOutputTest1") {
    assertEquals(listOutput(List()), "Empty list")
    assertEquals(listOutput(3 :: List()), "The number is 3")
    assertEquals(listOutput(2 :: 5 :: 3 :: List()), "Multiple numbers, with head being 2")
    assertEquals(listOutput(10 :: 3 :: List()), "The numbers are 10 and 3")
  }
}

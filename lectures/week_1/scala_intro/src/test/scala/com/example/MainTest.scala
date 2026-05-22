class MainTest extends org.scalatest.funsuite.AnyFunSuite {
  test("Cube function") {
    assert(Main.cube(3) === 27)
  }

  test("Get max of list"){
    assert(Main.getMax(List(1,2,3,4,5)) == 5)
  }

  test("Get max company!"){
    val listOfCompanies = List(("company_one", 45.9), ("company_two", 5.1), ("company_three", 7.8))

    assert(Main.getMaxCompany(listOfCompanies) == ("company_one", 45.9))
  }
 
  test("Prepending to list"){
    val expectedList: List[Int] = List(1, 2, 3, 4, 5)
    val resultingList = Main.prependToList(List(2, 3, 4, 5), 1)
    assert(expectedList == resultingList)
  }

  test("Appending to list"){
    val expectedList: List[Int] = List(1, 2, 3, 4, 5)
    val resultingList = Main.appendToList(List(1, 2, 3, 4), 5)
    assert(expectedList == resultingList)
  }

  test("Combining lists"){
    val expectedList: List[Int] = List(1, 2, 3, 4, 5)
    val resultingList = Main.combineLists(List(1, 2, 3), List(4, 5))
    assert(expectedList == resultingList)
  }

  // Uh oh!  This one is breaking
  test("Pattern matching on lists"){
    assert(Main.patternMatchingOnLists(List(1,2,3,4)) == 1)
    assert(Main.patternMatchingOnLists(List()) == 0)
    assert(Main.patternMatchingOnLists(List(1,2)) == 1)
  }
}

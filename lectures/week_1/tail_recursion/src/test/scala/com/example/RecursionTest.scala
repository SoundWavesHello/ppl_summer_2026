class RecursionTest extends org.scalatest.funsuite.AnyFunSuite {

  test("add list elements together"){
    val myList = List(1,2,3,4,5)
    assert(Recursion.addListRecursive(myList) == myList.sum)
  }

  test("tail recursive add list elements together") {
    val myList = List(1, 2, 3, 4, 5)
    assert(Recursion.addListTailRec(myList) == myList.sum)
  }

  test("filter list with if/else") {
    val myList = List(1,2,3,4,5,6,7,34,8,3,4,5)
    
    assert(Recursion.filterListIfElse(myList, 86).equals(myList))
    
    assert(Recursion.filterListIfElse(myList, 5).equals(myList.filter(x => x != 5)))

    // write your test cases here

  }

  test("filter list with pattern matching") {
    val myList = List(1,2,3,4,5,6,7,34,8,3,4,5)
    
    assert(Recursion.filterListMatching(myList, 86).equals(myList))
    
    assert(Recursion.filterListMatching(myList, 5).equals(myList.filter(x => x != 5)))

    // write your test cases here

  }

  test("tail recursive filter with pattern matching"){
    val myList = List(1, 2, 3, 4, 5, 6, 7, 34, 8, 3, 4, 5)

    assert(Recursion.filterListMatching(myList, 86).equals(myList))

    assert(Recursion.filterListMatching(myList, 5).equals(myList.filter(x => x != 5)))

    // write your test cases here
  }

  test("fibonnaci sequence") {

    assert(Recursion.nthFibonnaciNumber(-3) == 0)

    assert(Recursion.nthFibonnaciNumber(0) == 0)

    assert(Recursion.nthFibonnaciNumber(1) == 1)

    // write your test cases here
  }

  test("balanced parentheses") {
    assert(Recursion.balancedParenthesesProblem("()"))

    assert(Recursion.balancedParenthesesProblem(""))

    assert(!Recursion.balancedParenthesesProblem(")("))

    // write your test cases here
  }


}

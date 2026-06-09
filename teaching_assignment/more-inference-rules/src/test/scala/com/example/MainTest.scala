class MainTest extends org.scalatest.funsuite.AnyFunSuite {

  def generateList(myList: List[Double]): MyList = {
    myList match {
      case Nil => EmptyList
      case head::tail => ListNode(NumberValue(head), generateList(tail))
    }
  }

  test("Deletion tests") {
    val valuesToInsert = List(6.0, 5.0, 3.0, 2.0, 1.0)

    val newList = generateList(valuesToInsert)

    assert(newList.delete(NumberValue(6.0)) == generateList(valuesToInsert.filter(_ != 6.0)), "Delete from head works")
    assert(newList.delete(NumberValue(5.0)) == generateList(valuesToInsert.filter(_ != 5.0)), "Delete from tail-ok works")
    assert(EmptyList.delete(NumberValue(5.0)) == ErrorValue, "Delete from empty list works")
    assert(newList.delete(NumberValue(4.0)) == ErrorValue, "Delete from tail-ERROR works")
  }

  test("Summation tests") {
    // What are my cases?  Refer to inference rules
  }

  test("isOrdered tests") {
    
  }


  test("Insertion tests") {
    // What are my cases?  Refer to inference rules
    val newList = generateList(List(1.0,3.0,5.0,6.0))

    assert(newList.insert(NumberValue(2)) == generateList(List(1,2,3,5,6)), "Insertion into tail is effective")
    assert(newList.insert(NumberValue(0)) == generateList(List(0,1,3,5,6)), "Insertion at head works")
    assert(EmptyList.insert(NumberValue(0)) == generateList(List(0)), "Insertion into empty list works")
  }
}

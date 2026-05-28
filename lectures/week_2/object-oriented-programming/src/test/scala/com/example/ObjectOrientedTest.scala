class ObjectOrientedTest extends org.scalatest.funsuite.AnyFunSuite {
  
  test("polymorphism test") {
     val mySquare = Square()
    assert(mySquare.isInstanceOf[Square])
    assert(mySquare.isInstanceOf[Rectangle])
  }

  test("object test"){
    val p0 = Person
    val p1 = Person
    assert(p0 == p1)

    p1.name = "Kevin"
    assert(p0.name == "Kevin")
  }

  test("class test"){
    val b1 = Bravo("hi", 1)
    val b2 = Bravo("hi", 1)
    val b3 = Bravo("bye", 2)

    assert(b1 == b2)
    assert(b2 != b3)

    val p0 = new PersonClass("Diana Prince", 123121234)
    val p1 = new PersonClass("Superwoman", 123121234)
    assert(p0.toString != p1.toString)
    assert(p0 == p1)
  }

  test("traits and abstract classes"){
    // val testObject = new Delta("test", 1234)
    // val testTrait = new TestTrait()
  }

  test("factory convention vs class convention"){
    val p0 = new FactoryPerson("Bob Dylan", 12345)
    val p1 = FactoryPerson("Bob", "Dylan", 54321)

    assert(p0.sameName(p1))
  }
}

class SimpleExampleTest extends org.scalatest.funsuite.AnyFunSuite {
  test("how does my zulu class look?") {
    
    val testCase = Zulu("Kevin")
    // Zulu should have greet
    assert(testCase.greet() == "hi Kevin")
    
    // Zulu.foo(n) should return 2 * n
    assert(testCase.foo(2) == 4)
  
  }

  test("how does my foxtrot class look?"){
    val testCase = Foxtrot("Kevin")
    // Foxtrot should have farewell
    assert(testCase.farewell() == "bye Kevin")
    
    // Foxtrot.foo(n) should return the name length + n
    assert(testCase.foo(2) == 7)
  }
}

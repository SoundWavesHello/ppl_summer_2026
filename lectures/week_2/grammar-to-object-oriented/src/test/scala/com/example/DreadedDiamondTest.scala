class DreadedDiamondTest extends org.scalatest.funsuite.AnyFunSuite {
  val testCase = ZuluDiamond("Kevin")
  
  test("zulu should have greet") {
    assert(testCase.greet() == "hi Kevin")
  }

  test("zulu should have farewell"){
    assert(testCase.farewell() == "bye Kevin")
  }

  test("Zulu.foo(n) should do . . . what?"){
    assert(testCase.foo(2) == 7) // This is my current best guess . . . let's see if it works
  }

/* 

Different programming languages handle this problem differently (some have explicit workarounds).
But this is how Scala does it:
    - Checks the class itself first (Zulu) for a function
    - Then goes to the far right (Charlie) to see if it has the function
    - Then goes into Alpha, as Charlie extends alpha, to see if it has the function
    - Then goes into Bravo to see if it has the function

Essentially checks our initial class, then works from right to left.

 */
  
}

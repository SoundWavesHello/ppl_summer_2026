/*
Refer to readme.md for details
Feel free to make a ListExampleTest.scala file in the test/scala/com/example/ directory to fire off tests

BNF grammar 
L => X 
   | Cons(n, L)
   
n is a number, Scala Double
X is used to represent a completely empty list; think of it as our epsilon case.

implement the .isOrdered() function, which returns true if our list L is in order, false if not

*/
sealed trait L {
    def hasHead(): Boolean
    def getHead(): Double
}

case object X extends L {
    def hasHead(): Boolean = false
    def getHead(): Double = 0
}

case class Cons(d: Double, l: L) extends L {
    def hasHead(): Boolean = true
    def getHead(): Double = d

}
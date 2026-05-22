import scala.annotation.tailrec

//Problem 1A

/** YOUR SOLUTION HERE **/

//Problem 1B

/** YOUR SOLUTION HERE **/

//Problem 2A
def logTenFloor(n: Int): Int = {
    require( n >= 1) // If this is violated, you will get a "requirement failed message"
    
    /** YOUR SOLUTION HERE **/
    ???
}

//Problem 2B

/** YOUR SOLUTION HERE **/

//Problem 3
def listOutput(myList: List[Int]): String = {
    myList match {
        case List() => "Empty list"
        case h :: List() => s"The number is $h"
        
        /** YOUR SOLUTION HERE **/
        ???

    }
}
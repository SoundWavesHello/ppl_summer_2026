import annotation.tailrec

object Recursion extends App {

  /*
  A function that simply adds together elements of a list in a recursive manner
   */

  def addListRecursive(myList: List[Int]): Int = {
    // base case
    if (myList.isEmpty) {
      0
    }
    else myList.head + addListRecursive(myList.tail) // recursive call
  }

  /*
  A function that adds together elements of a list with tail recursion
   */
  @tailrec
  def addListTailRec(myList: List[Int], acc: Int = 0): Int = {
    if (myList.isEmpty) {
      acc
    } else{
      addListTailRec(myList.tail, acc + myList.head)
    }
  }


  /*
  A function that takes in a list and a target to filter out of the list.  Returns
  the list in its original order, just without that target element.

  Couple of helpful things:
    - list.head
    - list.tail
    - :: operator takes the element to the left and adds it to the head of the list on the right
    - List() or Nil for an empty list
   */
  def filterListIfElse(myList: List[Int], target: Int): List[Int] = {
    // base case
    if (myList.isEmpty){
      Nil
    }
    else if (myList.head == target){
      filterListIfElse(myList.tail, target) 
    } else{
      myList.head :: filterListIfElse(myList.tail, target)
    }
  }


  /* Same as our function above, except you aren't allowed to use the if/else keywords
   */
  def filterListMatching(myList: List[Int], target: Int): List[Int] = {
    myList match {
      case Nil => Nil
      case head :: tail => head match {
        case `target` => filterListMatching(tail, target)
        case _ => head :: filterListMatching(tail, target)
      }
    }
  }

  // def filterListMatchingWithTailRec(myList: List[Int], target: Int, acc: List[Int] = Nil) = {
  //   myList match {
  //     case Nil => ???
  //     case head :: Nil => ???
  //     case head :: tail =>???
  //   }
  // }

  /* A function that takes an integer n and returns the nth number of a
    fibonnaci sequence.  Worth noting: I consider the sequence to be
    0, 1, 1, 2, 3, 5, 8, . . ., where 0 is the 0th element.  Anything with
    an index of lower than 0 should also return 0.
   */
  def nthFibonnaciNumber(n: Int): Int = {
    // base case
    if (n <= 0) {
      0
    } else if (n == 1) {
      1
    }
    else {
      // recursive call
      nthFibonnaciNumber(n - 1) + nthFibonnaciNumber(n - 2)
    }

  }

  /*
  A function that takes in an equation of only parantheses and returns whether the
  equation is balanced or not. (()))()) => ) => )
   */


  def balancedParenthesesProblem(equation: String): Boolean = {
    // "myString" contains "String"
    // .replace() method on a string to remove a substring
    // && operator for and
    // || operator for or
    // .length() method on a string to check its length

    // base case for if its true
    // base case for if its false
    // recursive call
    false
  }
}
object Main extends App {

  // Some introductory functions!

  // a function that takes in an integer and returns that integer to the third power
  def cube(x: Int): Int = {
    x * x * x
  }

  // a function that takes in a list of integers and returns the maximum value
  def getMax(myList: List[Int]): Int = {
    var temp = 0
    for (element <- myList){
      if(element > temp){
        temp = element
      }
    }

    temp
  }

  /*  a function that takes in a list of tuples, where the first element is a company name 
    (string) and the second element is the company's current stock price, then returns 
    the company with the highest stock price
   */ 
  def getMaxCompany(list: List[(String, Double)]): (String, Double) = {
    var maxComp = list.head

    for( l <- list){
      if(l._2 > maxComp._2) {
        maxComp = l
      }
    }
    maxComp
  }
  
  
  // some list operators!

  // a couple of different ways to add things to list
  def prependToList(myList: List[Int], newElement: Int) = {
    // remember myList.head and myList.tail?
    newElement :: myList
    newElement +: myList

  }
  // myList = (1,2,3,4)
  // newElement = 5
  // result = (1,2,3,4,5)
  def appendToList(myList: List[Int], newElement: Int) = {
    //:+
    myList :+ newElement
  }

  // a way to combine lists
  def combineLists(firstList: List[Int], secondList: List[Int]) = {
    // ++
    firstList ++ secondList
  }

  val testList = List(1,2,3,4,5)

  // matching . . . and capturing
  // returns 1st element of a list if length = 1
  // returns 2nd element of a list if length = 2+
  // returns 0 if list is empty
  def patternMatchingOnLists(myList: List[Int]): Int = {
    myList match {
      case head::Nil => head
      case head::tail => tail.head
      case _ => 0
    }

    // ultimately, we're just testing on the ability to return the first element of a list that is 1 or more elements
    // Nil if not . . .
  }

  def makeList(element: Int): List[Int] = {
    element :: Nil
    element :: List()
  }

  // write a function that takes in a list of tuples, where each tuple contains a string and an integer
  // the function should return "yay" if the first element contains the integer 57
  // the function should return "nah" if the first element contains the integer 57 and the string "fish"
  // the function should return the string in the second element if the list is longer than 2 elements 
  // the function should return "definitely not" if the list is empty
  def matchPatterns(myList: List[(String, Int)]): String = {
    ""
  }
}
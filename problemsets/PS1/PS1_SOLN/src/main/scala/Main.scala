import scala.annotation.tailrec

//Problem 1A
def outputConsecutivePairs(lst: List[(Int, Int)]): List[(Int, Int)] = {
    var ret_list: List[(Int, Int)] = Nil
    for (elt <- lst) {
        val diff = elt._1 - elt._2
        if (-1 <= diff && diff <= 1) {
            ret_list = ret_list :+ elt
        }
    }
    ret_list
}

//Problem 1B
def outputConsecutivePairsRec(lst: List[(Int, Int)]): List[(Int, Int)] = {
    if (lst.isEmpty) {
        lst
    } else {
        val h :: t = lst
        val (a, b) = h
        val diff = (a - b).abs
        if (diff <= 1) {
            h :: outputConsecutivePairsRec(t)
        } else {
            outputConsecutivePairsRec(t)
        }
    }
}

//Problem 2A
def logTenFloor(n: Int): Int = {
    require( n >= 1) // If this is violated, you will get a "requirement failed message"
    if (n < 10) {
        0
    } else {
        1 + logTenFloor(n/10)
    }
}

//Problem 2B
@tailrec
def logTenFloorTail(n: Int, acc: Int = 0): Int = { 
    require(n >= 1)
    if (n < 10) {
        acc
    } else {
        logTenFloorTail(n/10, acc + 1)
    }
}

//Problem 3
def listOutput(myList: List[Int]): String = {
    myList match {
        case List() => "Empty list"
        case h :: List() => s"The number is $h"
        case h :: t :: List() => s"The numbers are $h and $t"
        case h :: _ => "Multiple numbers, with head being " + h
    }
}
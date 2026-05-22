# CSCI 3155 Problem Set 1: Scala Programming, Tail Recursion and Pattern Matching  

1. This assignment asks you to write scala programs. There are restrictions associated with how you can solve these problems. Please pay careful heed to those. If you are unsure ask your TA or post on piazza.
2. Use the test cases provided to test your solutions. You are encouraged to write your own tests and you are typically given a space to write these tests. **Unless otherwise specified, your personal tests will NOT be graded.**
3. **Very Important:** You are responsible to ensure that your work is submitted correctly. We recommend, after uploading your solution to Canvas, then download the submission and confirm that the correct file was provided for grading.  
4. **Very Important:** Your code will be implemented in **src/main/scala/Main.scala**. Tests are written for you in **src/test/scala/MySuite.scala**. These tests passing, along with adherence to the restrictions outlined for each problem, will determine your grade for the problem set.

## Problem 1 Part A (20 points)  

You will have the chance to solve the following problem in different ways.  

Given a list of pairs of integers, for example  

List( (1, 5), (2, 7), (15, 14), (18, 19), (14, 28), (0,0), (1,3), (3155, 3157), (35, 24) )  

Output a list consisting of just those pairs (n1, n2) in the original list wherein |n1 - n2| <= 1. Ensure that the order of the elements in the output list is the same as that in the input list.

For the example above, the expected output is:  

List( (15,14), (18,19), (0,0) )  

* Restrictions:
  * Your function must be called outputConsecutivePairs with exactly one argument that must be a list of pairs of integers. It must return a list of pairs of integers.
* You can use
  * You can use for-loops and the following operators for concatenating elements to list.
  * +:, :: or cons prepends an element to the front of a list.
  * :+ appends an element to the back of a list.
  * ++ concatenates two lists together.
  * You can use list API functions: reverse and length
  * You can use the scala Int.abs and Double.abs methods as you see fit.
  * There are no restrictions on the use of vars for this part of the problem
* you can NOT use
  * You should not use any other list API functions including filter, map, foldLeft, foldRight and so on. Plenty of time to learn them properly later on.
  * You should not use java's Math.abs
  * Do not try to convert your list to an array or vector so that you can mutate it.
* If you are unable to solve the problem without violating the restrictions or unsure, ask us privately on piazza or ask a member of the course staff during office hours.  

## Problem 1 Part B (20 points)
* Reimplement your code from part A with the following restrictions
* Name your function outputConsecutivePairsRec
* You are allowed to use:
  * list operators: head, tail, +:, ::, isEmpty
  * list API functions: head, tail, isEmpty, reverse, and length
  * Int.abs and Double.abs
* You are NOT allowed to use:
  * The keyword var
  * Any other list API functions including filter, map, foldLeft, foldRight and so on.
  * The list API functions: :+ or ++
  * Math.abs
* If you are unable to solve the problem without violating the restrictions or unsure, ask us privately on piazza or ask a member of the course staff during office hours.  

## Problem 2 Part A (20 points)  
Given a positive integer *n*, we wish to compute *floor(log10(n))*. Recall *floor* of a real number is the largest integer that is less than or equal to the real number. Write a recursive function **logTenFloor(n: Int): Int** that does the same. Ensure that your precondition restricts the inputs to *n > 0*.  

* Examples
  * logTenFloor(0) is not defined
  * logTenFloor(10) is 1
  * logTenFloor(99) is 1
  * logTenFloor(100) is 2
  * logTenFloor(999) is 2
  * more generally
  * logTenFloor(n) is 0 if n is in range 1 to 9
  * logTenFloor(n) is 1 if n is in range 10 to 99
  * logTenFloor(n) is 2 if n is in range 100 to 999
  * and so on
* Here is an article on Logarithms if you need a refresher: https://en.wikipedia.org/wiki/Logarithm
* Restrictions:
  * Solution must be recursive, does not need to be tail recursive for this part of the problem.
  * Can NOT use the keyword return
  * Can NOT use var, for, or while  

## Problem 2 Part B (20 points)  
Now, write a tail recursive version of the logTenFloor function, called logTenFloorTail.

* Restrictions:
  * Function must be named logTenFloorTail
  * Function must take only one paremeter that does not have a defaulted argument. To create tail recursion, you may either:
    * Use a helper function inside the scope of logTenFloorTail that is tail recursive
    * Or use additional parameters to logTenFloorTail with default arguments such that the function itself is tail recursive.
  * Solution must be tail recursive including the @tailrec decorator in the correct place
  * Can NOT use the keywords return, var, for, or while  

## Problem 3 (20 points)
Let's write a function with pattern matching. The function listOutput takes in type List[Int] and returns a type String.

For a empty list output "Empty list".

For a list with a single element output "The number is $n$".

The first two cases are given, write the cases below:
* For a list that has two elements output "The numbers are $n1$ and $n2$"
* For a list that has more than two elements output "Multiple numbers, with head being $n$"
# CSCI 3155 Problem Set 2: Object Oriented Programming (OOP)  

1. This assignment asks you to write scala programs. There are restrictions associated with how you can solve these problems. Please pay careful heed to those. If you are unsure ask your TA or post on piazza.
2. Use the test cases provided to test your solutions. You are encouraged to write your own tests and you are typically given a space to write these tests. **Unless otherwise specified, your personal tests will NOT be graded.**
3. **Very Important:** You are responsible to ensure that your work is submitted correctly. We recommend, after uploading your solution to Canvas, then download the submission and confirm that the correct file was provided for grading.  
4. **Very Important:** Your code will be implemented in **src/main/scala/Main.scala**. Tests are written for you in **src/test/scala/MySuite.scala**. These tests passing, along with adherence to the restrictions outlined for each problem, will determine your grade for the problem set.

## Problem 1: Grammar to Code (30 points)  
Convert the following grammar to an object class hierarchy:
$$\begin{array}{lll}
Spencer & \Rightarrow & Abhishek \\
& | & Alex(Spencer) \\
& | & Ali \\
& | & Andrew \\
& | & Emanuel(Spencer, Abhishek, Varun) \\
& | & Gunn(Spencer, Ali) \\
\\
Abhishek & \Rightarrow & Varun \\
& | & Izzy(Ali, Varun, Ali) \\
& | & Neena(Ali, Ali, Vaurn) \\
& | & Simon \\
\\
Varun & \Rightarrow & Tyler(Spencer) \\
& | & Yohanes \\
\\
Ali & \Rightarrow & Aaron \\
& | & Harley \\
& | & Jack \\
& | & Rahul \\
& | & Kailen \\
& | & Saud \\
\end{array}$$
* ***Restrictions:*** 
    * You may use `sealed trait`, `case class`, and `case object`
    * If you use standard `class` and `object`, then you must define an `apply` method
    * You may not use `sealed abstract class`  

## Problem 2: Binary Trees (70 points)  
### Provided
In the below problem we will demonstrate operations on binary tree structures including: 
* `BinaryTree + n` will add a number `n` to each data member of `BinaryTree` to create and return a new `BinaryTree`
* `BinaryTree.sum` will calculate and return the sum of all data members in the `BinaryTree`
    * For convenience we let the sum of the empty tree be `0`

### Problem to Solve
You are tasked with implementing the logic for operations on binary tree structures including:
* `BinaryTree * n` will muliply a number `n` to each data member of `BinaryTree` to create and return a new `BinaryTree`
* `BinaryTree.prod` will calculate and return the product of all data members in the `BinaryTree`
    * For convenience, we let the product of the empty tree be `1`
    
### Grammar
Here is the grammar that will describe our tree structure for this assignment

$$\begin{array}{lll}
BinaryTree & \Rightarrow & EmptyTree \\
& | & Node(BinaryTree, n, BinaryTree) \\
\\
&& \texttt{n is a number}
\end{array}$$

### Common mistake
Be advised, we are working in the world of functional programming. So, `+` and `*` do not mutate the existing tree, but rather they will create a new tree that looks like a mutated version of the original tree. Review `+` for inspiration.

### Problem 2 Part A: Vistor Pattern (30 points)
* Implement `*` and `prod` using the visitor pattern.
* ***Restrictions***
    * Must use the visitor pattern
    * Can NOT use the keyword `return`
    * Can NOT use the keyword `match`  

### Problem 2 Part B: Pattern Matching (30 points)  
* Implement `*` and `prod` using pattern matching.
* ***Restrictions***
    * Must use pattern matching keyword `match` in a reasonable way to solve the problem
    * Can NOT use the keyword `return`
    * Can NOT use the visitors pattern directly  

### Problem 2 Part C: Calling Methods (10 points)  
* Consider the below use of `<object>.<method>(<arg>)` vs `<object> <method> <arg>`
    * i.e. `x.+(y)` vs `x + y`  
```
    val myTree = Node(EmptyTree, 5, EmptyTree)
    val t1 = myTree + 5
    val t1Alt = myTree.+(5)
    assert(t1 == t1Alt)
```

* Complete similar code using the `*` method
* Define `t2` and `t2Alt` such that their values are `Node(EmptyTree, 25, EmptyTree)`
* ***Restrictions***
    * You MUST use  `<object>.*(<arg>)` at some point in defining t2
    * You MUST use  `<object> * <arg>` at some point in defining t2Alt
    * You are allowed to use other methods and intermediate variables as you see fit
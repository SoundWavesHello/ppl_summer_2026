A quick review of our object oriented programming keywords in Scala:
- trait
- sealed
- case
- abstract
- class
- object

A quick review of our BNF grammar:

Everything is divided up into terminals and non-terminals

Ex: Binary

$$\begin{array}{lll}
Bits & \Rightarrow &  Bit & Bits \\
& | & Bit \\
\\
Bit & \Rightarrow & 0 \\
& | & 1 \\
\end{array}$$

So let's think about this a little bit in terms of Object Oriented programming?

What would Bits be?  What about Bit?  (if the recursive nature of this is a bit odd and confusing, that's to be expected)


As far as lecture goes today, we're going to be going through our files in the following order:
- SimpleExample.scala
- DreadedDiamond.scala
- BinaryTree.scala
- MoreComplicatedEXample.scala

Once we're done with those, there are going to be a few examples to work through, if we have time.

Try implementing some functionality in the ListExample.scala file:
* The following are implemented for us:
    * `prepend: Int => List`
    * `append: Int => List`
* Implement the following methods
    * `isOrdered: () => Boolean`
    * `insert: Int => List` (assumes an ordered List)
    * `deleteMin: () => List`
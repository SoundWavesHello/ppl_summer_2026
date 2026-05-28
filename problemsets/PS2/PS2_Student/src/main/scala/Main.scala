//Problem 1
// _YOUR_CODE_HERE_

//Problem 2 Part A
sealed trait BinaryTreeVisitor {
    
    // PROVIDED
    def +(n: Int): BinaryTreeVisitor
    
    // PROVIDED
    def sum: Int
    
    // _YOUR_CODE_HERE_
    ???
    
}


case object EmptyTreeVisitor extends BinaryTreeVisitor {
    
    // PROVIDED
    def +(n: Int): BinaryTreeVisitor = {
        EmptyTreeVisitor
    }
    
    // PROVIDED
    def sum: Int = {
        0
    }
    
    // _YOUR_CODE_HERE_

    // *
    ???

    // prod
    ???
    
}


case class NodeVisitor(left: BinaryTreeVisitor, data: Int, right: BinaryTreeVisitor) extends BinaryTreeVisitor {
    
    // PROVIDED
    def +(n: Int): BinaryTreeVisitor = {
        val newLeft = this.left + n  // the x + y notation
        val newRight = this.right.+(n)  // the x.+(y) notation
        val newData = this.data + n
        val newTree = NodeVisitor(newLeft, newData, newRight)
        newTree
    }
    
    // PROVIDED
    def sum: Int = {
        // use of keyword `this` is optional
        left.sum + data + right.sum
    }
    
    // _YOUR_CODE_HERE_

    // *
    ???

    // prod
    ???

}

//Problem 2 Part B
sealed trait BinaryTreePattern {
    
    // PROVIDED
    def +(n: Int): BinaryTreePattern = {
        this match {
            case EmptyTreePattern => {
                EmptyTreePattern
            }
            case NodePattern(left, data, right) => {
                val newLeft = left + n     // x + y
                val newRight = right.+(n)  // x.+(y)
                val newData = data + n
                NodePattern(newLeft, newData, newRight)
            }
        }
    }
    
    // PROVIDED
    def sum: Int = {
        this match {
            case EmptyTreePattern => 0
            // can change the names at match side if you want
            case NodePattern(l, d, r) => l.sum + d + r.sum
        }
    }
    
    // _YOUR_CODE_HERE_

    // *
    ???

    // prod
    ???


}


case object EmptyTreePattern extends BinaryTreePattern
case class NodePattern(x: BinaryTreePattern, y: Int, z: BinaryTreePattern) extends BinaryTreePattern

//Problem 2 Part C

// PROVIDED
val myTree = NodeVisitor(EmptyTreeVisitor, 5, EmptyTreeVisitor)
val t1 = myTree + 5
val t1Alt = myTree.+(5)

// _YOUR_CODE_HERE
val t2 = ???
val t2Alt = ???
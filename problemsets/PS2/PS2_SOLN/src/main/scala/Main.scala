//Problem 1
sealed trait Spencer
case class Alex(s: Spencer) extends Spencer
case object Andrew extends Spencer
case class Emanuel(s: Spencer, a: Abhishek, v: Varun) extends Spencer
case class Gunn(s: Spencer, a: Ali) extends Spencer

sealed trait Abhishek extends Spencer
case class Izzy(a1: Ali, v: Varun, a2: Ali) extends Abhishek
case class Neena(a1: Ali, a2: Ali, v: Varun) extends Abhishek
case object Simon extends Abhishek

sealed trait Varun extends Abhishek
case class Tyler(s: Spencer) extends Varun
case object Yohanes extends Varun

sealed trait Ali extends Spencer
case object Aaron extends Ali
case object Harley extends Ali
case object Jack extends Ali
case object Kailen extends Ali
case object Rahul extends Ali
case object Saud extends Ali

//Problem 2 Part A
sealed trait BinaryTreeVisitor {
    
    // PROVIDED
    def +(n: Int): BinaryTreeVisitor
    
    // PROVIDED
    def sum: Int
    
    // _YOUR_CODE_HERE_
    def *(n: Int): BinaryTreeVisitor
    def prod: Int
    
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
    def *(n: Int): BinaryTreeVisitor = this
    def prod: Int = 1
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
    def *(n: Int): BinaryTreeVisitor = {
        NodeVisitor(this.left * n, this.data * n, this.right * n)
    }
    def prod: Int = {
        left.prod * data * right.prod
    }
    
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
    def *(n: Int): BinaryTreePattern = {
        this match {
            case EmptyTreePattern => EmptyTreePattern
            case NodePattern(l, d, r) => NodePattern(l * n, d * n, r * n)
        }
    }
    
    def prod: Int = {
        this match {
            case EmptyTreePattern => 1
            case NodePattern(l, d, r) => l.prod * d * r.prod
        }
    }
}


case object EmptyTreePattern extends BinaryTreePattern
case class NodePattern(x: BinaryTreePattern, y: Int, z: BinaryTreePattern) extends BinaryTreePattern

//Problem 2 Part C
val myTree = NodeVisitor(EmptyTreeVisitor, 5, EmptyTreeVisitor)
val t1 = myTree + 5
val t1Alt = myTree.+(5)

val x = NodeVisitor(EmptyTreeVisitor, 1, EmptyTreeVisitor)
val t2 = x * (x + 4).sum * 5
val t2Alt = x.*((x.+(4)).prod).+(20)
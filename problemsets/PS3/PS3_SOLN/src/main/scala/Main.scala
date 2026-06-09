// emptyTreeError
// https://stackoverflow.com/questions/38243530/custom-exception-in-scala
final case class DeleteFromEmptyTreeException(private val message: String = "", 
                           private val cause: Throwable = None.orNull)
                      extends Exception(message, cause) 

//Problem 1A
sealed trait BinaryTree {

    //Problem 1B
    def insert(newValue: Double): BinaryTree = {
        this match {
            case EmptyTree => {
                TreeNode(EmptyTree, newValue, 1, EmptyTree)
            }
            case TreeNode(left, data, count, right) if newValue < data => {
                val newLeft = left insert newValue
                TreeNode(newLeft, data, count, right)
            }
            case TreeNode(left, data, count, right) if newValue == data => {
                val newCount = count + 1
                TreeNode(left, data, newCount, right)
            }
            case TreeNode(left, data, count, right) => {  // if newValue > data
                val newRight = right insert newValue
                TreeNode(left, data, count, newRight)
            }
        }
    }

    //Problem 1C
    def deleteMin(): BinaryTree = {
        this match {
            case EmptyTree => {
                throw new DeleteFromEmptyTreeException("cannot delete the minimum value from an empty tree")  // emptytreeerror
            }
            case TreeNode(EmptyTree, data, count, right) if count == 1 => right
            case TreeNode(EmptyTree, data, count, right) => {
                val newCount = count - 1
                TreeNode(EmptyTree, data, newCount, right)
            }
            case TreeNode(left, data, count, right) => {
                val newLeft = left.deleteMin()
                TreeNode(newLeft, data, count, right)
            }
        }
    }

    //Problem 1D
    def isValidSearchTree(min: Double = Double.MinValue, 
                          max: Double = Double.MaxValue): Boolean = {
        this match {
            case EmptyTree => true
            case TreeNode(_, _, c, _) if (c < 1) => false
            case TreeNode(l, d, _, r) => 
                    d > min &&
                    d < max &&
                    l.isValidSearchTree(min, d) &&
                    r.isValidSearchTree(d, max)
        }
    }

}

//Problem 1A
case object EmptyTree extends BinaryTree
case class TreeNode(l: BinaryTree, data: Double, count: Int, r: BinaryTree) extends BinaryTree

//Problem 2A
sealed trait Maths {

    //Problem 2B
    def eval(): Value = {
        def hBop(m1: Maths, m2: Maths)(f: (Double, Double) => Double) = {
            m1.eval() match {
                case NumValue(n1) => m2.eval() match {
                    case NumValue(n2) => NumValue(f(n1, n2))
                    case err => err
                }
                case err => err
            }
        }
        this match {
            case v: Value => v
            case Plus(m1, m2) => hBop(m1, m2){ _ + _ }
            case Minus(m1, m2) => hBop(m1, m2){ _ - _ }
            case Times(m1, m2) => hBop(m1, m2){ _ * _ }
            case Div(m1, m2) => {
                m1.eval() match {
                    case err: MathsError => err
                    case NumValue(d1) => m2.eval() match {
                        case NumValue(0) => DivByZeroError
                        case NumValue(d2) => NumValue(d1/d2)
                        case err => err
                    }
                }
            }
            case TryCatch(m1, m2) => {
                m1.eval() match {
                    case v1@NumValue(d1) => v1
                    case DivByZeroError => m2.eval()
                }
            }
            case v@NumValue(d) => v
            case _ => ???
        }
    }
}

//Problem 2A
case class Plus(m1: Maths, m2: Maths) extends Maths
case class Minus(m1: Maths, m2: Maths) extends Maths
case class Times(m1: Maths, m2: Maths) extends Maths
case class Div(m1: Maths, m2: Maths) extends Maths
case class TryCatch(m1: Maths, m2: Maths) extends Maths

sealed trait Value extends Maths
case class NumValue(d: Double) extends Value

sealed trait MathsError extends Value
case object DivByZeroError extends MathsError
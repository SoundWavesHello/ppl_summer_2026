/* 
  Going to spend today continuing to dive into LinkedLists and the inference 
  rules that pertain to them

  Refer to the readMe for our BNF grammar.  Please note that we're utilizing eval, 
  expressions and values now
  
  The delete function we have below is from last Tuesday's lecture . . . 
  let's recall those particular inference rules

  Now let's think about the BNF grammar that we used . . . 
  do we need to adjust the delete function to account for our new BNF grammar?
 */


sealed trait Value
case object ErrorValue extends Value
case class BooleanValue(b: Boolean) extends Value
case class NumberValue(n: Double) extends Value

sealed trait MyList extends Value {

  // delete function
  def delete(target: NumberValue): Value = {
      this match {
          case EmptyList => ErrorValue
          case ListNode(n_head, l_tail) if target.n == n_head.n => l_tail
          // Why is my IDE getting tetchy with me here?  Any guesses?
          case ListNode(n_head, l_tail) if target.n != n_head.n => l_tail.delete(target) match {
              case ErrorValue => ErrorValue
              case l_tailNew: MyList => ListNode(n_head, l_tailNew)
          }
          case _ => ???
      }
  }

  /*

  -------------------- summation-empty-list
  sum(X) = NumValue(0)


  sum(L) = NumValue(sum_of_tail)
  -----------------------------------------
  sum(NumValue(n) -> L) = NumValue(n + sum_of_tail)

  */

  // summation function
  def sum(): Value = {
    this match {
      case EmptyList => NumberValue(0)
      case ListNode(n_head, l_tail) => {
        l_tail.sum() match{
          case NumberValue(n) => NumberValue(n_head.n + n)
          case _ => ErrorValue
        }
        
      }
      case _ => ErrorValue
    }
  }

  /* 
  
  ---------------------------------------- insert-into-empty-list
  insert(X, NumValue(n)) = NumValue(n) -> X

  OldList = NumValue(h) -> L, n < h
  ----------------------------------------------------- insert-here-non-empty-list
  insert(OldList, NumValue(n)) = NumValue(n) -> OldList

  OldList = NumValue(h) -> L, n >= h, insert(L, NumValue(n)) = newTail
  --------------------------------------------------------------------- insert-tail-non-empty-list
  insert(OldList, NumValue(n)) = NumValue(h) -> newTail

   */

  // insert function (with error for non-integer element)
  def insert(v: Value): Value = {
    v match {
      case BooleanValue(b) => ErrorValue
      case ErrorValue => ErrorValue
      case NumberValue(n) => {
        this match {
          case EmptyList => ListNode(NumberValue(n), EmptyList)
          case ListNode(n_head, l_tail) if n < n_head.n => ListNode(NumberValue(n), ListNode(n_head, l_tail))
          case ListNode(n_head, l_tail) if n >= n_head.n => {
            l_tail.insert(v) match {
              case list: MyList => ListNode(NumberValue(n), list)
              case _ => ErrorValue
            }
            
      }
      }
    }
  }
    
  }

  // isOrdered function
  def isOrdered(): Value = {
    ???
  }


  // what about different error types?
}

// TODO: do we need to adjust these to handle the new BNF Grammar?
case object EmptyList extends MyList
case class ListNode(n_head: NumberValue, l_tail: MyList) extends MyList


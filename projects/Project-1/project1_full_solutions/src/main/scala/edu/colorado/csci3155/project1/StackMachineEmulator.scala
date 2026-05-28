package edu.colorado.csci3155.project1

import scala.annotation.tailrec



sealed trait StackMachineInstruction
/*-- Complete the byte code instructions as specified in the documentation --*/
case class LoadEnv(s: String) extends StackMachineInstruction
case class  StoreEnv(s: String) extends StackMachineInstruction
case object PopEnv extends StackMachineInstruction

case class PushNumI(f: Double) extends StackMachineInstruction
case class PushBoolI(b: Boolean) extends StackMachineInstruction
case object AddI extends StackMachineInstruction
case object SubI extends StackMachineInstruction
case object MultI extends StackMachineInstruction
case object DivI extends StackMachineInstruction
case object ExpI extends StackMachineInstruction
case object LogI extends StackMachineInstruction
case object SinI extends StackMachineInstruction
case object CosI extends StackMachineInstruction
case object GeqI extends StackMachineInstruction
case object EqI extends StackMachineInstruction 
case object NotI extends StackMachineInstruction
case object PopI extends StackMachineInstruction

case class CSkipI(numToSkip: Int) extends StackMachineInstruction
case class SkipI(numToSkip: Int) extends StackMachineInstruction

object StackMachineEmulator {

    /*-- An environment stack is a list of tuples containing strings and values --*/
    type RuntimeStack = List[(String, Value)]
    /*-- An operand stack is a list of values --*/
    type OpStack = List[Value]

    /* Function emulateSingleInstruction
        Given a list of values to represent a operand stack
              a list of tuples (string, value) to represent runtime stack
        and   a single instruction of type StackMachineInstruction
        Return a tuple that contains the
              modified stack that results when the instruction is executed.
              modified runtime that results when the instruction is executed.

        Make sure you handle the error cases: eg., stack size must be appropriate for the instruction
        being executed. Division by zero, log of a non negative number
        Throw an exception or assertion violation when error happens.
     */
    def emulateSingleInstruction(stack: OpStack,
                               env  : RuntimeStack,
                               ins  : StackMachineInstruction): (OpStack, RuntimeStack) = {

      def binNum(op: (Double, Double) => Double,
                 stk: OpStack): OpStack = stk match {
          case Num(v1) :: Num(v2) :: rest => Num(op(v2, v1)) :: rest
          case _  => throw new RuntimeException("numeric operands expected")
      }

      def pop1(stk: OpStack): (Value, OpStack) = stk match {
          case v :: rest => (v, rest)
          case Nil       => throw new RuntimeException("operand stack underflow")
      }

      ins match {
          case LoadEnv(x) =>
              val (v, s1) = pop1(stack)
              (s1, (x, v) :: env)

          case StoreEnv(x) =>
              env.find(_._1 == x) match {
                  case Some((_, v)) => (v :: stack, env)
                  case None         => throw new RuntimeException(s"unbound identifier $x")
              }

          case PopEnv =>
              env match {
                  case _ :: rest => (stack, rest)
                  case Nil       => throw new RuntimeException("runtime stack underflow")
              }

          case PopI =>
              val (_, s1) = pop1(stack); (s1, env)

          case PushNumI(f)  => (Num(f)  :: stack, env)
          case PushBoolI(b) => (Bool(b) :: stack, env)

          case AddI  => (binNum(_ + _, stack), env)
          case SubI  => (binNum(_ - _, stack), env)
          case MultI => (binNum(_ * _, stack), env)
          case DivI =>
            ( binNum( (v2, v1) => {
                  if (v1 == 0) throw new RuntimeException("division by zero")
                  v2 / v1
                },
                stack),
              env )

          case LogI =>
              stack match {
                  case Num(v) :: rest if v > 0 => (Num(math.log(v)) :: rest, env)
                  case Num(_) :: _             => throw new RuntimeException("log of non-positive")
                  case _                       => throw new RuntimeException("numeric operand expected")
              }

          case ExpI =>
              stack match {
                  case Num(v) :: rest => (Num(math.exp(v)) :: rest, env)
                  case _              => throw new RuntimeException("numeric operand expected")
              }

          case SinI =>
            stack match {
                case Num(v) :: rest => (Num(math.sin(v)) :: rest, env)
                case _              => throw new RuntimeException("numeric operand expected")
            }

          case CosI =>
            stack match {
                case Num(v) :: rest => (Num(math.cos(v)) :: rest, env)
                case _              => throw new RuntimeException("numeric operand expected")
            }

          case GeqI =>
              stack match {
                  case Num(v1) :: Num(v2) :: rest => (Bool(v2 >= v1) :: rest, env)
                  case _                          => throw new RuntimeException("numeric operand expected")
              }

          case EqI =>
              stack match {
                  case v1 :: v2 :: rest => (Bool(v1 == v2) :: rest, env)
                  case _                => throw new RuntimeException("operand stack underflow")
              }

          case NotI =>
              stack match {
                  case Bool(b) :: rest => (Bool(!b) :: rest, env)
                  case _               => throw new RuntimeException("boolean operand expected")
              }

          case other =>
              throw new RuntimeException(s"unexpected instruction $other inside emulator")
      }
  }

    /* Function emulateStackMachine
       Execute the list of instructions provided as inputs using the
       emulateSingleInstruction function.
       Return the final runtimeStack and the top element of the opStack
     */
    @tailrec
    def emulateStackMachine(instructionList: List[StackMachineInstruction], 
                            opStack: OpStack=Nil, 
                            runtimeStack: RuntimeStack=Nil): (Value, RuntimeStack) =
        {
            /*-- Are we out of instructions to execute --*/
            if (instructionList.isEmpty){
                /*-- output top elt. of operand stack and the runtime stack --*/
                (opStack.head, runtimeStack)
            } else {
                /*- What is the instruction on top -*/
                val ins = instructionList.head
                ins match {
                    /*-- Conditional skip instruction --*/
                    case CSkipI(n) => {
                        /* get the top element in operand stack */
                        val topElt = opStack.head 
                        val restOpStack = opStack.tail 
                        val b = topElt.getBooleanValue /* the top element better be a boolean */
                        if (!b) {
                            /*-- drop the next n instructions --*/
                            val restOfInstructions = instructionList.drop(n+1)
                            emulateStackMachine(restOfInstructions, restOpStack, runtimeStack)
                        } else {
                            /*-- else just drop this instruction --*/
                            emulateStackMachine(instructionList.tail, restOpStack, runtimeStack)
                        }
                    }
                    case SkipI(n) => {
                        /* -- drop this instruction and next n -- continue --*/
                        emulateStackMachine(instructionList.drop(n+1), opStack, runtimeStack)
                    }

                    case _ => {
                        /*- Otherwise, just call emulateSingleInstruction -*/
                        val (newOpStack: OpStack, newRuntime:RuntimeStack) = emulateSingleInstruction(opStack, runtimeStack, ins)
                        emulateStackMachine(instructionList.tail, newOpStack, newRuntime)
                    }
                }
            }
        }
}
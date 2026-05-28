package edu.colorado.csci3155.project1

object StackMachineCompiler {


    /* Function compileToStackMachineCode
        Given expression e as input, return a corresponding list of stack machine instructions.
        The type of stackmachine instructions are in the file StackMachineEmulator.scala in this same directory
        The type of Expr is in the file Expr.scala in this directory.
     */
    def compileToStackMachineCode(e: Expr): List[StackMachineInstruction] = {

        def bin(e1: Expr, e2: Expr, ins: StackMachineInstruction) =
            compileToStackMachineCode(e1) ++
            compileToStackMachineCode(e2) :+
            ins

        e match {
            case Const(f)        => List(PushNumI(f))
            case BoolConst(b)    => List(PushBoolI(b))
            case Ident(x)        => List(StoreEnv(x))

            case Plus(a,b)       => bin(a,b, AddI)
            case Minus(a,b)      => bin(a,b, SubI)
            case Mult(a,b)       => bin(a,b, MultI)
            case Div(a,b)        => bin(a,b, DivI)
            case Exp(a)          => compileToStackMachineCode(a) :+ ExpI
            case Log(a)          => compileToStackMachineCode(a) :+ LogI
            case Sine(a)         => compileToStackMachineCode(a) :+ SinI
            case Cosine(a)       => compileToStackMachineCode(a) :+ CosI

            case Geq(a,b)        => bin(a,b, GeqI)
            case Eq(a,b)         => bin(a,b, EqI)
            case Not(a)          => compileToStackMachineCode(a) :+ NotI

            case IfThenElse(c,t,e2) =>
                val L0 = compileToStackMachineCode(c)
                val L1 = compileToStackMachineCode(t)
                val L2 = compileToStackMachineCode(e2)
                L0 ++
                List(CSkipI(L1.length + 1)) ++
                L1 ++
                List(SkipI(L2.length)) ++
                L2

            case And(a,b) =>
                val L1 = compileToStackMachineCode(a)
                val L2 = compileToStackMachineCode(b)
                L1 ++
                List(CSkipI(L2.length + 1)) ++
                L2 ++
                List(SkipI(1)) ++
                List(PushBoolI(false))

            case Or(a,b)  =>        // very different code; shame on you
                val L1 = compileToStackMachineCode(a)
                val L2 = compileToStackMachineCode(b)
                L1 ++
                List(CSkipI(L2.length + 1)) ++          //List(CSkip(L2.length + 1)) here 
                L2 ++ List(SkipI(1), PushBoolI(true))

            case Let(x,e1,e2) =>
                val L1 = compileToStackMachineCode(e1)
                val L2 = compileToStackMachineCode(e2)
                L1 ++
                List(LoadEnv(x)) ++
                L2 :+
                PopEnv
            case _ => throw new IllegalArgumentException(s"Unhandled expression $e")
        }
    }
}

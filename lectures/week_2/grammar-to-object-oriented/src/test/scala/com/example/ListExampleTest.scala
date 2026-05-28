package com.example

class ListExampleTest extends org.scalatest.funsuite.AnyFunSuite {
    val orderedList = Cons(2, Cons(4, Cons(5, Cons(6, X))))
    val outOfOrder = Cons(6, Cons(5, Cons(4)))
    val emptyList = X

    test("getHead"){
        assert(orderedList.getHead == 2)
        assert(emptyList.getHead == 0)
    }

    test("hasHead"){
        assert(orderedList.hasHead)
        assert(!emptyList.hasHead)
    }

    test("append"){
        val temp = orderedList.append(7)
        assert(temp == Cons(2, Cons(4, Cons(5, Cons(6, Cons(7, X))))))
    }
}

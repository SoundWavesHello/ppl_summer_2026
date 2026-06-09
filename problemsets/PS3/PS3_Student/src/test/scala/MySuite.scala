class MySuite extends munit.FunSuite {

  test("p1GrammarTest") {
    val t0 = EmptyTree
    assert(t0.isInstanceOf[BinaryTree])
    val t1 = TreeNode(t0, 1300, 1, t0)
    assert(t1.isInstanceOf[BinaryTree])
    val t2 = TreeNode(t1, 2270, 2, TreeNode(t0, 3155, 3, t0))
    assert(t2.isInstanceOf[BinaryTree])
  }

  test("insertTest1") {
    val t0 = EmptyTree
    val n0 = 2270
    assertEquals(t0 insert n0, TreeNode(t0, n0, 1, t0))
  }

  test("insertTest2") {
    val t0 = EmptyTree
    val n0 = 2270
    val t1 = TreeNode(t0, n0, 1, t0)
    assertEquals(t1 insert n0, TreeNode(t0, n0, 2, t0))
  }

  test("insertTest3") {
    val t0 = EmptyTree
    val n0 = 2270
    val t1 = TreeNode(t0, n0, 1, t0)
    val n1 = 1300
    assertEquals(t1 insert n1, TreeNode(TreeNode(t0, n1, 1, t0), n0, 1, t0))

    val n2 = 3155
    assertEquals(t1 insert n2, TreeNode(t0, n0, 1, TreeNode(t0, n2, 1, t0)))
  }


  test("deleteMinTest1") {
    val t0 = EmptyTree
    val err = new DeleteFromEmptyTreeException

    intercept[DeleteFromEmptyTreeException] {
      t0.deleteMin()
    }

  }

  test("deleteMinTest2") {
    val t0 = EmptyTree
    val t1 = TreeNode(t0, 2270, 1, t0)
    assertEquals(t1.deleteMin(), t0)
  }


  test("deleteMinTest4") {
    val t0 = EmptyTree
    val l = List(
        TreeNode(TreeNode(t0, 1300, 1, t0), 2270, 2, TreeNode(TreeNode(t0, 2275, 1, t0), 3155, 3, t0)),
        TreeNode(t0, 2270, 2, TreeNode(TreeNode(t0, 2275, 1, t0), 3155, 3, t0)),
        TreeNode(t0, 2270, 1, TreeNode(TreeNode(t0, 2275, 1, t0), 3155, 3, t0)),
        TreeNode(TreeNode(t0, 2275, 1, t0), 3155, 3, t0),
        TreeNode(t0, 3155, 3, t0),
        TreeNode(t0, 3155, 2, t0),
        TreeNode(t0, 3155, 1, t0),
        t0
        )

    (l zip l.tail) foreach {
        case (t, tp) => assertEquals(t.deleteMin(), tp)
    }

  }



  test("isValidSearchTreeTest2") {
    val t0 = EmptyTree

    // inductive cases
    val t1 = TreeNode(TreeNode(t0, Double.MaxValue, 15, t0), 10, 1, t0)
    assertEquals(t1.isValidSearchTree(), false)

    val t2 = TreeNode(TreeNode(t0, 0, -2, t0), 10, 1, t0)
    assertEquals(t2.isValidSearchTree(), false)

    val t3 = TreeNode(TreeNode(t0, 0, 3, TreeNode(t0, -1, 1, t0)), 10, 1, t0)
    assertEquals(t3.isValidSearchTree(), false)

    val t4 = TreeNode(TreeNode(t0, 0, 3, TreeNode(t0, 20, 1, t0)), 10, 1, t0)
    assertEquals(t4.isValidSearchTree(), false)
  }

  test("p2GrammarTest1") {
    val err = DivByZeroError
    assert(err.isInstanceOf[MathsError])
    assert(err.isInstanceOf[Value])
    assert(err.isInstanceOf[Maths])
  }

  test("p2GrammarTest2") {
    val v = NumValue(1.0)
    assert(!v.isInstanceOf[MathsError])
    assert(v.isInstanceOf[Value])
    assert(v.isInstanceOf[Maths])
  }



  test("evalTest1") {
    // 1 == 1
    assertEquals(NumValue(1.0).eval(), NumValue(1))
    // err == err
    assertEquals(DivByZeroError.eval(), DivByZeroError)
  }

  test("evalTest2") {
    // 2 + 3 == 5
    assertEquals(Plus(NumValue(2.0), NumValue(3.0)).eval(), NumValue(5.0))
    // 4 - 5 == -1
    assertEquals(Minus(NumValue(4.0), NumValue(5.0)).eval(), NumValue(-1.0))
    // 6 * 7 == 42
    assertEquals(Times(NumValue(6.0), NumValue(7.0)).eval(), NumValue(42.0))
  }

  test("evalTest3") {
    // 1 / 2 == 0.5
    assertEquals(Div(NumValue(1.0), NumValue(2.0)).eval(), NumValue(0.5))
    // 3 / 0 == err
    assertEquals(Div(NumValue(3.0), NumValue(0.0)).eval(), DivByZeroError)
  }

  test("evalTest4") {
    // try { err } catch { 5 } == 5
    assertEquals(TryCatch(DivByZeroError, NumValue(5.0)).eval(), 
                NumValue(5))
    // try { 3155 } catch { 5 } == 3155
    assertEquals(TryCatch(NumValue(3155), NumValue(5.0)).eval(), 
                NumValue(3155))
  }

  test("evalTest6") {
    // try { 1 + 2 * 3 / 4 } catch { 5 } == 2.5
    val m0 = NumValue(4)
    val m1 = Div(NumValue(3), m0)
    val m2 = Times(NumValue(2), m1)
    val m3 = Plus(NumValue(1), m2)
    val m4 = TryCatch(m3, NumValue(5))
    assertEquals(m4.eval(), NumValue(2.5))
  }

}
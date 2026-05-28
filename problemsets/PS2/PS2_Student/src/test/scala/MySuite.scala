class MySuite extends munit.FunSuite {

  test("Problem 1 - Test 1") {
    val x0 = Aaron
    val x1 = Harley
    val x2 = Jack
    val x3 = Kailen
    val x4 = Rahul
    val x5 = Saud
    for (x <- List(x0, x1, x2, x3, x4, x5)) {
        assert(x.isInstanceOf[Spencer])
        assert(!x.isInstanceOf[Abhishek])
        assert(!x.isInstanceOf[Varun])
        assert(x.isInstanceOf[Ali])
    }
  }

  test("Problem 1 - Test 2") {
    val x0 = Tyler(Andrew)
    val x1 = Yohanes
    for (x <- List(x0, x1)) {
        assert(x.isInstanceOf[Spencer])
        assert(x.isInstanceOf[Abhishek])
        assert(x.isInstanceOf[Varun])
        assert(!x.isInstanceOf[Ali])
    }
  }

  test("Problem 1 - Test 3") {
    val x0 = Izzy(Jack, Yohanes, Kailen)
    val x1 = Neena(Rahul, Saud, Yohanes)
    val x2 = Simon
    for (x <- List(x0, x1, x2)) {
        assert(x.isInstanceOf[Spencer])
        assert(x.isInstanceOf[Abhishek])
        assert(!x.isInstanceOf[Varun])
        assert(!x.isInstanceOf[Ali])
    }
  }


  test("Problem 2A") {
    val t0 = EmptyTreeVisitor
    val t1 = NodeVisitor(t0, 5, t0)
    val t2 = NodeVisitor(t0, 15, t0)
    val t3 = NodeVisitor(t1, 10, t2)

    assertEquals({ t3 + 2 }, NodeVisitor(NodeVisitor(t0, 7, t0), 12, NodeVisitor(t0, 17, t0)))
    assertEquals({ t3.sum }, 30)
    assertEquals({ (t3 + 2).sum }, 36)

    assertEquals({ t0 * 2 }, t0)
    assertEquals({ t0.prod }, 1)
    
    assertEquals({ t3.prod }, 750)


    assertEquals({ (t3 * 2).prod }, 6000)
  }

  test("Problem 2B") {
    val t0 = EmptyTreePattern
    val t1 = NodePattern(t0, 5, t0)
    val t2 = NodePattern(t0, 15, t0)
    val t3 = NodePattern(t1, 10, t2)

    assertEquals({ t3 + 2 }, NodePattern(NodePattern(t0, 7, t0), 12, NodePattern(t0, 17, t0)))
    assertEquals({ t3.sum }, 30)
    assertEquals({ (t3 + 2).sum }, 36)


    assertEquals({ t0.prod }, 1)
    
    assertEquals({ t3.prod }, 750)

    assertEquals({ (t0 * 2).prod }, 1)
    assertEquals({ (t3 * 2).prod }, 6000)

  }

  test("Problem 2C") {
    assertEquals(t2, NodeVisitor(EmptyTreeVisitor, 25, EmptyTreeVisitor))
  }

}

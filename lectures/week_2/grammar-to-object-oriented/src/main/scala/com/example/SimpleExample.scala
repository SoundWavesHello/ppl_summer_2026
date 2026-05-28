/* 

What about a simpler example?

My BNF grammar is the following (s is a string)

Alpha   => Bravo 
         | Charlie
Bravo   => Zulu(s)
Charlie => Foxtrot(s)


 */

trait Alpha {
    val name: String
    def foo(n: Int): Int
}

trait Bravo extends Alpha {
    override def foo(n: Int): Int = {
        n * 2
    }
    def greet(): String = s"hi $name"
}


trait Charlie extends Alpha  {
    override def foo(n: Int): Int = {
        n + name.length
    }

    def farewell(): String = s"bye $name"
}

// Note: two ways to initialize expected attribute values
case class Zulu(param: String) extends Bravo{
  override val name = param
}

case class Foxtrot(name: String) extends Charlie



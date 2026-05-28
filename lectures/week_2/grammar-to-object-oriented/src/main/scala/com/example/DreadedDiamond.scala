/* 

What if I make this a little more commplicated?

My BNF grammar is the following (s is a string)

Alpha   => Bravo 
         | Charlie
Bravo   => Zulu(s)
Charlie => Zulu(s)

I've added "Diamond" onto our classes so the compiler doesn't get mad at us.

But we can see that the inheritance for zulu resembles a diamond

 */

trait AlphaDiamond {
    val name: String
    def foo(n: Int): Int
}

trait BravoDiamond extends AlphaDiamond {
    override def foo(n: Int): Int = {
        n * 2
    }
    def greet(): String = s"hi $name"
}


trait CharlieDiamond extends AlphaDiamond  {
    override def foo(n: Int): Int = {
        n + name.length
    }

    def farewell(): String = s"bye $name"
}


case class ZuluDiamond(name: String) extends BravoDiamond with CharlieDiamond
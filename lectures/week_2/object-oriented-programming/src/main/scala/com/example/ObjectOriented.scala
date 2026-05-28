

/*

A couple of pillars to be aware of with object-oriented programming:
  - Abstraction
  - Inheritance
  - Encapsulation
  - Polymorphism

 */


 // Abstraction - Defining our objects/classes and controlling what parts
 // the user can access

 // Inheritance - all squares are rectangles, so squares inherit the 
 // features of rectangles
 sealed trait Rectangle
 case class Square() extends Rectangle

 /* 

 A couple of keywords here:
  - sealed -> only things in the same file can inherit this 
  - trait -> a bit like an template/interface
  - case -> gives us some built in functionality; we'll get into this one a little later
  - extends -> this is our way of defining inheritance

  General inheritance rules in Scala:
    - What can be inherited?
    - How many things can a given class inherit from?
  */


/* 

Encapsulation - I want to control when/where things are accessed

Why might I do that?

Some brief examples:
 */

sealed trait TestTrait
trait OtherTrait
private case class TestClass() extends TestTrait

 /* 

 Polymorphism 
 - Follows hand-in-hand with inheritance
 - I should be able to use a child object where a function expects its parent
 - In some cases, I can cast a parent object into its child object as needed (this gets complicated though)

 See test class
  */

/* 

Objects vs. Classes . . . what is the difference?

An object is an instance of a class

 */

// Objects (when implemented this way) come with significant drawbacks
object Person {
    var name: String = "John Doe"
    private val ssn: Int = 123121234

    override def toString: String = {
        // "Person(" + name + ")"  // Choose either. Be consistent.
        s"Person($name)"
    }
}

// Classes allow for more flexibility
case class Bravo(val foo: String, val bar: Int){
  // def ==(that: Bravo): Boolean = {
  //       if (this.foo == that.foo) {
  //           if (this.bar == that.bar) {
  //               true
  //           } else {
  //               false
  //           }
  //       } else {
  //           false
  //       }
  //   }
}


class PersonClass (val name: String, private val ssn: Int) {
    override def toString: String = {
        // "Person(" + name + ")"  // Choose either. Be consistent.
        s"Person($name)"
    }
    
    def ==(that: PersonClass) = this.ssn == that.ssn
}

/* 
Abstract classes:
  - Very similar to traits -> can only inherit one; default constructor
  - But you can toss in a default constructor
 */

abstract class Delta(foo: String, bar: Int){
  val temp = foo
  val ssn = bar
}

/* 
The factory convention . . . lets you chain together object creation pretty quickly
 */

class FactoryPerson(val name: String, private val ssn: Int){
  def sameName(person: FactoryPerson): Boolean = {
    this.name == person.name
  }
}

// maybe I have a table
// with first and last names
// and I want to be able to create them that way
object FactoryPerson {
    def apply(name: String, ssn: Int) = {
        new FactoryPerson(name, ssn)
    }
    
    def apply(first: String, last: String, ssn: Int) = {
        val name = s"$first $last"
        new FactoryPerson(name, ssn)
    }
}

// 'case' keyword automatically applies this paradigm, so we no longer need to use the 'new' keyword

case class MyClass(foo: String, bar: Int)

// multiple inheritance
abstract class Echo()
sealed trait Foxtrot
sealed trait Golf
case class Hotel()

class Indigo() extends Hotel with Foxtrot with Golf
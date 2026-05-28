package com.example

sealed trait CanSpeak {
    def speak(): Unit = {
    }
}

sealed trait Moveable {
    def move(): Unit = {
        print("Default move trait")
    }
}

// animal can't be made directly
abstract class Animal() extends Moveable{

}

// has a species name

case class Dog() extends Animal with CanSpeak {
//    override def move(): Unit = {
//        print("Dog runs")
//    }
}

case class Slug() extends Animal {
    override def move(): Unit = {
        print("Slug moves slowly")
    }
}

case class Rock() extends Moveable

// can speak
// can move
// NON-animal can also move (without default impl)

// implement some traits/classes for this to work
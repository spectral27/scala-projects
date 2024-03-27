package org.example;

@main def hello(): Unit =
  println("Hello, World!")
  val point = Point()
  point.x = 1
  println(point.toJson)

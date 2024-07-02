package org.example

@main def hello(): Unit =
  println("Creating Point()")
  val point = Point()
  point.x = 1
  println(point.toJson)
  
  println("Calling Point's addTen() method")
  point.addTen(point)
  println(point.toJson)

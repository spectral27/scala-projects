package org.example

class Point:
  var x: Int = 0

  def toJson: String =
    val sb = new StringBuilder()
    sb ++= "{\n"
    sb ++= s"  \"x\": $x\n"
    sb ++= "}"
    sb.toString
    
  def addTen(point: Point): Unit =
    point.x = point.x + 10

end Point

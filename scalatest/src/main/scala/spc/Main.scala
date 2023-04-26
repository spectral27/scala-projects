package spc

import spc.ObjectPrinter.printScalaObject

@main def main(): Unit =
  val scalaObject = ScalaObject("Scala", "3.2.2")
  println(s"${scalaObject.vendor} ${scalaObject.version}")
  printScalaObject(scalaObject)

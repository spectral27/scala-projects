package spc

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

object ObjectPrinter:

  val jackson: ObjectMapper = ObjectMapper()
  jackson.registerModule(DefaultScalaModule)

  def printScalaObject(scalaObject: ScalaObject): Unit =
    val json = jackson.writerWithDefaultPrettyPrinter()
      .writeValueAsString(scalaObject)
    println(json)

end ObjectPrinter

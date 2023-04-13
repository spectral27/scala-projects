package spc

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig

import java.net.URI

@main def main(): Unit =
  val uri = URI.create("http://0.0.0.0:8080")
  val resourceConfig = ResourceConfig()
  resourceConfig.packages("spc")
  GrizzlyHttpServerFactory.createHttpServer(uri, resourceConfig)

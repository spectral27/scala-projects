package spc

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.ws.rs.ext.ContextResolver
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.internal.inject.AbstractBinder
import org.glassfish.jersey.server.ResourceConfig

import java.net.URI

@main def main(): Unit =
  val uri = URI.create("http://0.0.0.0:8080")
  val resourceConfig = ResourceConfig()
  resourceConfig.packages("spc")
  GrizzlyHttpServerFactory.createHttpServer(uri, resourceConfig)

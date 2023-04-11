package spc

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.ext.{ContextResolver, Provider}
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider

@Provider
class JacksonProvider extends JacksonJaxbJsonProvider:

  val jackson: ObjectMapper = ObjectMapper()
  jackson.registerModule(DefaultScalaModule)
  setMapper(jackson)

end JacksonProvider

package spc

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import jakarta.ws.rs.ext.Provider
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider

@Provider
class JacksonProvider extends JacksonJaxbJsonProvider:

  val jackson: ObjectMapper = ObjectMapper()
  jackson.registerModule(DefaultScalaModule)
  setMapper(jackson)

end JacksonProvider

package spc

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Inject
import jakarta.ws.rs.core.{MediaType, Response}
import jakarta.ws.rs.{GET, Path, Produces}

import scala.collection.mutable.ListBuffer
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import jakarta.ws.rs.core.Response.StatusType
import org.glassfish.grizzly.http.util.HttpStatus

@Path("/test")
class TestController:

  val repository: TestRepository = TestRepository()

  @GET
  @Produces(Array("application/json"))
  def selectRecords(): Response =
    val records = repository.selectRecords()
    val record = RecordObject()
    record.identifier = "a0b1c2d3"
    records.append(record)
    Response.status(Response.Status.OK).entity(records).build()

end TestController

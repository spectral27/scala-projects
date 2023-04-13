package spc

import jakarta.ws.rs.core.Response
import jakarta.ws.rs.{Consumes, DELETE, GET, POST, PUT, Path, PathParam, Produces}

import java.io.{PrintWriter, StringWriter}

@Path("/test")
class TestController:

  private val repository: TestRepository = TestRepository()

  @GET
  @Produces(Array("application/json"))
  def selectRecords(): Response =
    val records = repository.selectRecords()
    Response.status(Response.Status.OK).entity(records).build()

  @POST
  @Consumes(Array("application/json"))
  def insertRecord(record: RecordObject): Response =
    repository.insertRecord(record)
    Response.status(Response.Status.OK).entity("Record added").build()

  @PUT
  @Path("/{id}")
  @Consumes(Array("application/json"))
  def updateRecord(@PathParam("id") id: String, updatedRecord: RecordObject): Response =
    try
      repository.updateRecord(id, updatedRecord)
      Response.status(Response.Status.OK).entity("Record updated").build()
    catch
      case npe: NullPointerException =>
        val exception = stackTrace(npe)
        Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception).build()

  @DELETE
  @Path("/{id}")
  def deleteRecord(@PathParam("id") id: String): Response =
    try
      repository.deleteRecord(id)
      Response.status(Response.Status.OK).entity("Record deleted").build()
    catch
      case npe: NullPointerException =>
        val exception = stackTrace(npe)
        Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception).build()

  private def stackTrace(e: Exception): String = 
    val stringWriter = StringWriter()
    val printWriter = PrintWriter(stringWriter)
    e.printStackTrace(printWriter)
    stringWriter.toString

end TestController

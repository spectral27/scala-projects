package spc

import spc.TestRepository.records

import java.util.UUID
import scala.util.control.Breaks._
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object TestRepository:
  val records: ArrayBuffer[RecordObject] = ArrayBuffer[RecordObject]()

class TestRepository:

  def selectRecords(): ArrayBuffer[RecordObject] =
    records
    
  def insertRecord(record: RecordObject): Unit =
    record.identifier = UUID.randomUUID().toString.replace("-", "").substring(0, 16)
    records += record

  def updateRecord(id: String, updatedRecord: RecordObject): Unit =
    var recordFound = false
    val it = records.iterator
    for record <- records do
      if (record.identifier.equals(id)) {
        record.value = updatedRecord.value
        recordFound = true
      }


//    while it.hasNext do
//      val record = it.next()
//      if (record.identifier.equals(id))
//        record.value = updatedRecord.value
//        recordFound = true
//    for i <- records.indices do
//      val record: RecordObject = records(i)
//      if (record.identifier.eq(id))
//        record.value = updatedRecord.value
//        recordFound = true
//    for record <- records do
//      if (record.identifier.eq(id))
//        record.value = updatedRecord.value
//        recordFound = true
    if (!recordFound)
      throw new NullPointerException("Record not found")

  def deleteRecord(id: String): Unit =
    var recordToDeleteId = -1
    var recordFound = false;
    breakable {
      for record <- records do
        if (record.identifier.eq(id))
          recordToDeleteId = records.indexOf(record)
          recordFound = true
          break
    }
    if (recordToDeleteId != -1 && recordFound)
      records.remove(recordToDeleteId)
    else
      throw new NullPointerException("Record not found")

end TestRepository

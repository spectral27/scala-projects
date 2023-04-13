package spc

import spc.TestRepository.records

import java.util.UUID
import scala.collection.mutable.ArrayBuffer

object TestRepository:
  var records: ArrayBuffer[RecordObject] = ArrayBuffer[RecordObject]()

class TestRepository:

  def selectRecords(): ArrayBuffer[RecordObject] =
    records
  
  def insertRecord(record: RecordObject): Unit =
    record.identifier = UUID.randomUUID().toString.replace("-", "").substring(0, 16)
    records += record

  def updateRecord(id: String, updatedRecord: RecordObject): Unit =
    var recordFound = false
    for record <- records do
      if record.identifier.equals(id) then
        record.value = updatedRecord.value
        recordFound = true
    if (!recordFound)
      throw new NullPointerException("Record not found")

  def deleteRecord(id: String): Unit =
    val (recordsToKeep, recordsToDelete) = records.partition(r => !r.identifier.equals(id))
    records = recordsToKeep
    if recordsToDelete.isEmpty then
      throw new NullPointerException("Record not found")

end TestRepository

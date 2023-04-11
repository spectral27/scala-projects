package spc

import spc.TestRepository.records

import scala.collection.mutable.ListBuffer

object TestRepository:
  val records: ListBuffer[RecordObject] = ListBuffer[RecordObject]()

class TestRepository:

  def selectRecords(): ListBuffer[RecordObject] =
    records
    
  def insertRecord(record: RecordObject): Unit =
    records.append(record)

end TestRepository

package spc

class RecordObject():
  
  private var _identifier: String = ""

  def identifier: String =
    _identifier

  def identifier_=(identifier: String): Unit =
    _identifier = identifier
    
end RecordObject

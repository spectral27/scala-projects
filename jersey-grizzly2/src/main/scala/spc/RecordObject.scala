package spc

class RecordObject():
  
  private var _identifier: String = ""
  private var _value: String = ""

  def identifier: String =
    _identifier

  def identifier_=(identifier: String): Unit =
    _identifier = identifier

  def value: String =
    _value

  def value_=(value: String): Unit =
    _value = value
    
end RecordObject

package com.franklinchen

import scala.util.Try

import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory

object XmlSchemaValidator {
  val schemaLang = "http://www.w3.org/2001/XMLSchema"
  val factory = SchemaFactory.newInstance(schemaLang)
  val source = new StreamSource(
    getClass.getResourceAsStream("/talkbank.xsd")
  )

  /**
    This takes a very long time.
    */
  val schema = factory.newSchema(source)

  def validate(streamSource: StreamSource): Try[Unit] = {
    Try {
      val validator = schema.newValidator()
      validator.validate(streamSource)
    }
  }
}

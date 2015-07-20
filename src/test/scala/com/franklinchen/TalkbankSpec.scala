package com.franklinchen

import org.specs2._

import scala.xml.XML

class TalkbankSpec extends Specification { def is = s2"""
  Parse sample document $e1
  Create XML using generated classes $e2
  """

  def e1 = {
    val elem = XML.load(getClass.getResource("/words.xml"))

    val root = scalaxb.fromXML[CHAT](elem)

    root.Id ==== "words"
  }

  def e2 = {
    val metadata = None
    val participants = Participants(
    )
    val chatoption = Nil
    // Constructing the tree is untyped.
    val attributes: Map[String, scalaxb.DataRecord[Any]] = Map(
      // The key seems redundant and unchecked here.
      "@huh" -> scalaxb.DataRecord(None, Some("huh"), "silly")
    )

    val chat = CHAT(
      metadata,
      participants,
      chatoption,
      attributes
    )

    // Argh, cannot validate the tree. Have to outsource to XML.

    val defaultScope = scalaxb.toScope(
      None -> "http://www.talkbank.org/ns/talkbank",
      Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance"
    )

    val elem = scalaxb.toXML[CHAT](
      chat,
      "CHAT",
      defaultScope
    )

    // TODO validate

    elem ==== <CHAT xmlns="http://www.talkbank.org/ns/talkbank" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"><Participants/></CHAT>
  }
}

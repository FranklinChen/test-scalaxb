package com.franklinchen

import org.specs2._

import scala.xml.XML

class HamshahriSpec extends Specification { def is = s2"""
  Parse sample document $e1
  """

  def e1 = {
    val elem = XML.load(getClass.getResource("/HAM2-960622.xml"))

    val root = scalaxb.fromXML[HAMSHAHRI2](elem)

    root.DOC(0).DOCID ==== "HAM2-750402-001"
  }
}

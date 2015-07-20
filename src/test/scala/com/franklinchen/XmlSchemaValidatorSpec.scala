package com.franklinchen

import org.specs2._

import java.io.StringReader
import javax.xml.transform.stream.StreamSource

class XmlSchemaValidatorSpec extends Specification { def is = s2"""
  Validate XML created using literals $e1
  Validate XML created using string $e2
  """

  /**
    XML copied straight from words.xml.
    */
  def e1 = {
    val elem = <CHAT xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns="http://www.talkbank.org/ns/talkbank"
      xsi:schemaLocation="http://www.talkbank.org/ns/talkbank http://talkbank.org/software/talkbank.xsd"
      Version="2.0.2"
      Lang="eng"
      Corpus="bates"
      Id="words"
      Date="1984-01-01">
  <Participants>
    <participant
      id="CHI"
      role="Child"
      language="eng"
      age="P1Y8M"
      ageTo="P1Y9M"
      sex="female"
      group="normal"

    />
    <participant
      id="MOT"
      role="Mother"
      language="eng"

    />
  </Participants>
  <u who="CHI" uID="u0">
    <w>hey</w>
    <w>man</w>
    <w>what</w>
    <w>in</w>
    <w>the</w>
    <w>world</w>
    <w>isn't</w>
    <w>this</w>
    <w>gonna<replacement><w>going</w><w>to</w></replacement></w>
    <t type="q"></t>

  </u>
  <u who="MOT" uID="u1">
    <w>hey</w>
    <w>woman</w>
    <w>what</w>
    <w>in</w>
    <w>the</w>
    <w>universe</w>
    <w>is</w>
    <w>in</w>
    <w>this</w>
    <w>fé</w>
    <t type="q"></t>

  </u>
</CHAT>

    val streamSource = new StreamSource(new StringReader(elem.toString))

    XmlSchemaValidator.validate(streamSource) must beSuccessfulTry
  }

  def e2 = {
    val elemString = """<CHAT xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns="http://www.talkbank.org/ns/talkbank"
      xsi:schemaLocation="http://www.talkbank.org/ns/talkbank http://talkbank.org/software/talkbank.xsd"
      Version="2.0.2"
      Lang="eng"
      Corpus="bates"
      Id="words"
      Date="1984-01-01">
  <Participants>
    <participant
      id="CHI"
      role="Child"
      language="eng"
      age="P1Y8M"
      ageTo="P1Y9M"
      sex="female"
      group="normal"

    />
    <participant
      id="MOT"
      role="Mother"
      language="eng"

    />
  </Participants>
  <u who="CHI" uID="u0">
    <w>hey</w>
    <w>man</w>
    <w>what</w>
    <w>in</w>
    <w>the</w>
    <w>world</w>
    <w>isn't</w>
    <w>this</w>
    <w>gonna<replacement><w>going</w><w>to</w></replacement></w>
    <t type="q"></t>

  </u>
  <u who="MOT" uID="u1">
    <w>hey</w>
    <w>woman</w>
    <w>what</w>
    <w>in</w>
    <w>the</w>
    <w>universe</w>
    <w>is</w>
    <w>in</w>
    <w>this</w>
    <w>fé</w>
    <t type="q"></t>

  </u>
</CHAT>"""

    val streamSource = new StreamSource(new StringReader(elemString))

    XmlSchemaValidator.validate(streamSource) must beSuccessfulTry
  }

}

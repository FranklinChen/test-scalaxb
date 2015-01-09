import ScalaxbKeys._

name := "test-scalaxb"

organization := "com.franklinchen"

organizationHomepage := Some(url("http://franklinchen.com/"))

homepage := Some(url("http://github.com/FranklinChen/text-scalaxb"))

startYear := Some(2013)

description := "Test using scalaxb"

version := "1.0.0"

scalaVersion := "2.11.5"

scalacOptions ++= Seq(
//  "-deprecation",
  "-feature",
  "-language:postfixOps",
  "-language:existentials",
  "-language:implicitConversions"
)

libraryDependencies ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, scalaMajor)) if scalaMajor >= 11 =>
      Seq(
        "org.scala-lang.modules" %% "scala-xml" % "1.0.3",
        "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3"
      )
    case _ =>
      Seq()
  }
}

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test",
  "org.specs2" %% "specs2" % "2.4.15" % "test"
)

scalaxbSettings

packageName in scalaxb in Compile := "com.franklinchen"

sourceGenerators in Compile <+= scalaxb in Compile

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

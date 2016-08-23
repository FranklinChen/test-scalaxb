import ScalaxbKeys._

name := "test-scalaxb"

organization := "com.franklinchen"

organizationHomepage := Some(url("http://franklinchen.com/"))

homepage := Some(url("http://github.com/FranklinChen/text-scalaxb"))

startYear := Some(2013)

description := "Test using scalaxb"

version := "1.0.0"

scalaVersion := "2.11.8"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-language:postfixOps",
  "-language:existentials",
  "-language:implicitConversions"
)

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.0.5",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",

  "org.specs2" %% "specs2-core" % "3.8.4" % Test
)

scalaxbSettings

packageName in scalaxb in Compile := "com.franklinchen"

sourceGenerators in Compile <+= scalaxb in Compile

unmanagedResourceDirectories in Compile += sourceDirectory.value / "main" / "xsd"

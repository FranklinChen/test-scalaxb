import ScalaxbKeys._

name := "test-scalaxb"

organization := "com.franklinchen"

organizationHomepage := Some(url("http://franklinchen.com/"))

homepage := Some(url("http://github.com/FranklinChen/text-scalaxb"))

startYear := Some(2013)

description := "Test using scalaxb"

version := "1.0.0"

scalaVersion := "2.10.3"

scalacOptions ++= Seq(
//  "-deprecation",
  "-feature",
  "-language:postfixOps",
  "-language:existentials",
  "-language:implicitConversions"
)

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.11.1" % "test",
  "org.specs2" %% "specs2" % "2.3.6" % "test"
)

scalaxbSettings

packageName in scalaxb in Compile := "com.franklinchen"

sourceGenerators in Compile <+= scalaxb in Compile

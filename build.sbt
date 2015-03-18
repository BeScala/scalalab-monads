name := """scalalab-monads"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.6"

val scalazVersion = "7.1.0"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.scalaz" %% "scalaz-effect" % scalazVersion,
  "org.scalaz" %% "scalaz-typelevel" % scalazVersion,
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion % "test"
)

scalacOptions += "-feature"

initialCommands in console := "import scalaz._, Scalaz._"

initialCommands in console in Test := "import scalaz._, Scalaz._, scalacheck.ScalazProperties._, scalacheck.ScalazArbitrary._, scalacheck.ScalaCheckBinding._, org.bescala.ScalazChecks._, org.bescala.Maybe._"



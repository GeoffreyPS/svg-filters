val scala_xml = "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.5"

lazy val commonSettings = Seq(
  version := "0.0.1",
  scalaVersion := "2.11.8"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "svg-transformer",
    libraryDependencies += scala_xml
  )
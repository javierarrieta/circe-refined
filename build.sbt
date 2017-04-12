import Dependencies._

val circeVersion = "0.7.0"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "javierarrieta",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Circe 604",
    libraryDependencies ++= Seq(
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion,
    "io.circe" %% "circe-generic-extras" % circeVersion,
    "com.chuusai" %% "shapeless" % "2.3.2",
    scalaTest % Test
    )
  )

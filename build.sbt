scalaVersion := "2.13.8"
name := "specs2-integration-tests-4.x"
organization := "org.specs2"
version := "1.0"
libraryDependencies += "org.specs2" %% "specs2-core" % "4.20.0" % "test"
Test / parallelExecution := false

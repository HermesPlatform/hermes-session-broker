name := """hermes-core"""
organization := "hermesplatform.core"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += "org.apache.ignite" % "ignite-core" % "2.9.1"
libraryDependencies += "org.apache.ignite" % "ignite-spring" % "2.9.1"


cancelable in Global := true
// Adds additional packages into Twirl
//TwirlKeys.templateImports += "hermesplatform.core.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "hermesplatform.core.binders._"

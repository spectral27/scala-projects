ThisBuild / name := "scalatest"
ThisBuild / version := "1.0.0"
ThisBuild / scalaVersion := "3.2.2"

lazy val root = (project in file("."))
  .settings(
    libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.15.0",
    libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_3" % "2.15.0",
    assembly / mainClass := Some("spc.main"),
    assembly / assemblyJarName := (ThisBuild / name).value + "-" + (ThisBuild / version).value + ".jar"
  )

ThisBuild / assemblyMergeStrategy := {
  case "META-INF/versions/9/module-info.class" => MergeStrategy.discard
  case "META-INF/MANIFEST.MF" => MergeStrategy.discard
  case _ => MergeStrategy.first
}

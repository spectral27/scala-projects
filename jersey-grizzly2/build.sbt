val scala3Version = "3.2.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "jersey-grizzly2",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.glassfish.jersey.media" % "jersey-media-json-jackson" % "3.1.1",
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.14.2",
      "org.glassfish.jersey.inject" % "jersey-hk2" % "3.1.1",
      "org.glassfish.jersey.containers" % "jersey-container-grizzly2-http" % "3.1.1",
      "org.glassfish.jaxb" % "jaxb-runtime" % "4.0.2"
    ),

    assembly / mainClass := Some("spc.main"),
    assembly / assemblyJarName := "runnable.jar"
  )

ThisBuild / assemblyMergeStrategy := {
  case "module-info.class" => MergeStrategy.discard
  case "META-INF/MANIFEST.MF" => MergeStrategy.discard
  case x => MergeStrategy.first
}

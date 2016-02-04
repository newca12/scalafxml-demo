name := "scalafxml-demo"

version := "0.0.1"

jfxSettings

JFX.mainClass := Some("org.edla.scalafxml.demo.AudioConfigScalaFXML")

JFX.nativeBundles := "all"

//required for Windows sbt package-javafx
//JFX.devKit := JFX.jdk("C:/Program Files/Java/jdk1.8.0_66")

scalaVersion := "2.11.7"

scalacOptions ++= Seq(
  "-language:postfixOps", "-language:existentials", "-language:implicitConversions",
  //"-optimize",
  "-deprecation",
  "-encoding", "UTF-8", // yes, this is 2 args
  "-feature",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture"
)

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafxml-core-sfx8" % "0.2.2",
  "org.scalafx" %% "scalafx" % "8.0.60-R9"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full)

fork := true

licenses := Seq("GNU GPL v3" -> url("http://www.gnu.org/licenses/gpl.html"))

homepage := Some(url("http://github.com/newca12/scalafxml-demo"))


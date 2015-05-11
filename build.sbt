
name := """kamon"""

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++=
  "io.kamon"          %% "kamon-core"      % "0.4.0" ::
  "io.kamon"          %% "kamon-scala"     % "0.4.0" ::
  "ch.qos.logback"    %  "logback-classic" % "1.1.2" ::
  "com.typesafe.akka" %% "akka-slf4j"      % "2.3.9" ::
  Nil


aspectjSettings

javacOptions := Seq("-source", "1.8", "-target", "1.8")

javaOptions in run <++= AspectjKeys.weaverOptions in Aspectj

fork in run := true

Revolver.settings

javaOptions in Revolver.reStart <++= AspectjKeys.weaverOptions in Aspectj

//Revolver.reForkOptions := Revolver.reForkOptions.value.copy(bootJars = Nil)

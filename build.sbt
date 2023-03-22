ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val Slow = config("slow").extend(Test) // see https://stackoverflow.com/questions/41229451/how-to-disable-slow-tagged-scalatests-by-default-allow-execution-with-option

lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin)
  .configs(Slow)
  .settings(
    // https://stackoverflow.com/questions/41229451/how-to-disable-slow-tagged-scalatests-by-default-allow-execution-with-option
    inConfig(Slow)(Defaults.testTasks),
    Test / testOptions += Tests.Filter(s => !s.endsWith("SlowTest")),
    Slow / testOptions := Seq(Tests.Filter(_.endsWith("SlowTest"))),
    name := "ScalaJSSlowTest",
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.11" % Test,
  )

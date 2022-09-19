ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "polingonsFx"
  )



libraryDependencies ++= Seq("org.scalafx" %% "scalafx" % "18.0.2-R29",
    "org.scalafx" %% "scalafxml-core-sfx8" % "0.5",
    "org.scala-lang.modules" %% "scala-swing" % "3.0.0",
    "mysql" % "mysql-connector-java" % "8.0.13"
)

// "org.scala-lang.modules" %% "scala-swing" % "3.0.0"
//"com.github.nscala-time" %% "nscala-time" % "2.32.0"
scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature", "-Ymacro-annotations")

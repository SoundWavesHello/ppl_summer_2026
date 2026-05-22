lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "3.5.2" // This should match the Scala version on your machine!
    )),
    name := "scala_intro"
  )


libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test

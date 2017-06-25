name := "exercises"

version := "1.0"

scalaVersion := "2.12.0"

libraryDependencies ++= Seq(

  /* scala test */
  "org.scalactic" %% "scalactic" % "3.0.0",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",

  // https://mvnrepository.com/artifact/org.mockito/mockito-all
  "org.mockito" % "mockito-all" % "1.10.19"


)

/*
lazy val root = (project in file(".")).
  settings(
    name := "exercises",
    version := "1.0",
    scalaVersion := "2.10.0",
    resolvers += Resolver.url("typesafe", url("http://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"
  )
*/
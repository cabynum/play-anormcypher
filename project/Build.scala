import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "play-anormcypher"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here 

      libraryDependencies ++= Seq(
    		"org.neo4j.app" % "neo4j-server" % "1.9.M01" classifier "static-web" classifier "",
    		"com.sun.jersey" % "jersey-core" % "1.9", "net.liftweb" %% "lift-json" % "2.4-M5",
    		"org.anormcypher" %% "anormcypher" % "0.2.1"
    		),

      resolvers ++= Seq(
    		"maven-central" at "http://repo1.maven.org/maven2",
    		"neo4j-public-repository" at "http://m2.neo4j.org/content/groups/public",
        "anormcypher" at "http://repo.anormcypher.org/"
    		) 
     
    )

}

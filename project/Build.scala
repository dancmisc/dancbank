import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "btbankapp"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "org.webjars" % "webjars-play" % "2.0",
      "org.webjars" % "bootstrap" % "2.1.1"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
      resolvers += "webjars" at "http://webjars.github.com/m2"
    )

}

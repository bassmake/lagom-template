
import com.lightbend.lagom.core.LagomVersion
import com.lightbend.lagom.sbt.LagomImport._
import sbt._

object Dependencies {

  object Versions {

    val NemeVersion =  "0.0.5"
    val TaggingVersion = "2.2.1"

    val ScalaTestVersion = "3.0.8"

  }

  object Libraries {

    import Versions._

    val neme = "com.softwaremill.neme" %% "neme-plugin" % NemeVersion
    val tagging = "com.softwaremill.common" %% "tagging" % TaggingVersion

    val lagomPlayJson = "com.lightbend.lagom" %% "lagom-scaladsl-play-json" % LagomVersion.current

    val scalaTest = "org.scalatest" %% "scalatest" % ScalaTestVersion
  }

  import Libraries._

  val CommonDeps = List(
    compilerPlugin(neme),
    tagging
  )

  val SharedDeps = List(
    lagomPlayJson
  )

  val DomainDeps = List(
    lagomScaladslPersistence,
    scalaTest % Test,
    lagomScaladslTestKit
  )
  val ApiDeps = List(
    lagomScaladslApi
  )

  val AppDeps = List()

}

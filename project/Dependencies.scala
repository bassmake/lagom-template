
import com.lightbend.lagom.core.LagomVersion
import com.lightbend.lagom.sbt.LagomImport._
import sbt._

object Dependencies {

  object Versions {

    val NemeVersion =  "0.0.5"
    val TaggingVersion = "2.2.1"

    val ScalaTestVersion = "3.1.0"

  }

  object Libraries {

    import Versions._

    val Neme = "com.softwaremill.neme" %% "neme-plugin" % NemeVersion
    val Tagging = "com.softwaremill.common" %% "tagging" % TaggingVersion

    val LagomPlayJson = "com.lightbend.lagom" %% "lagom-scaladsl-play-json" % LagomVersion.current
  }

  import Libraries._

  val CommonDeps = List(
    compilerPlugin(Neme),
    Tagging
  )

  val SharedDeps = List(
    LagomPlayJson
  )

  val DomainDeps = List(
    lagomScaladslPersistence
  )

  val ApiDeps = List(
    lagomScaladslApi
  )

  val AppDeps = List()

}

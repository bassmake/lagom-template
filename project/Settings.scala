import Dependencies._

import com.softwaremill.SbtSoftwareMill
import com.softwaremill.SbtSoftwareMill.autoImport._
import sbt.Keys.libraryDependencies
import sbt._
import wartremover.Wart

object Settings {

  lazy val commonSettings: SettingsDefinition = smlBuildSettings ++ Seq(
    libraryDependencies ++= CommonDeps
    // your settings, which can override some of smlBuildSettings
  )

  private lazy val smlBuildSettings =
    commonSmlBuildSettings    ++ // compiler flags
      splainSettings            ++ // gives rich output on implicit resolution errors
      dependencyUpdatesSettings ++ // check dependency updates on startup (max once per 12h)
      wartRemoverSettings       ++ // warts
      acyclicSettings           ++ // check circular dependencies between packages
      ossPublishSettings           // configures common publishing process for all OSS libraries
}

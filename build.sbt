import Dependencies._
import Settings._

ThisBuild / name := "lagom-template"
ThisBuild / version := "0.1"
ThisBuild / organization := "sk.bsmk"
ThisBuild / scalaVersion := "2.12.10"
ThisBuild / scalafmtOnCompile := true

lazy val `dynamic-message-forwarder` = (project in file("."))
  .settings(
    name := "lagom-template"
  )

lazy val shared = (project in file("shared"))
  .settings(
    commonSettings,
    libraryDependencies ++= SharedDeps
  )

lazy val `shared-domain` = (project in file("domain/shared"))
  .settings(
    name := "shared-domain",
    commonSettings,
    libraryDependencies ++= DomainDeps
  )
  .dependsOn(shared)

lazy val domain = (project in file("domain"))
  .settings(
    commonSettings,
    libraryDependencies ++= DomainDeps
  )
  .dependsOn(
  )
  .aggregate(
    `shared-domain`
  )

lazy val api = (project in file("api"))
  .settings(
    commonSettings,
    libraryDependencies ++= ApiDeps
  )
  .dependsOn(shared)

lazy val app = (project in file("app"))
  .settings(
    commonSettings,
    libraryDependencies ++= AppDeps
  )
  .dependsOn(
    domain,
    api
  )

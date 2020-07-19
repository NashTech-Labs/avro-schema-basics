import Dependencies._

name := "avro-schema-blog"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= compiledDependencies(
  sparkAvro,
  typeSafeConfig,
  avroHugger
)++ testDependencies(
  scalaTest
)
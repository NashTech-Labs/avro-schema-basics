import sbt._

object Dependencies {
  def compiledDependencies(deps: ModuleID*): Seq[ModuleID] = deps.map(_ % Compile)

  def testDependencies(deps: ModuleID*): Seq[ModuleID] = deps.map(_ % Test)

  val kafkaVersion = "0.10.0.0"
  val sparkVersion = "2.4.3"
  val typeSafeConfigVersion = "1.3.4"

  val sparkCore =   "org.apache.spark" %% "spark-core" % sparkVersion
  val sparkSql = "org.apache.spark" %% "spark-sql" % sparkVersion
  val sparSqlKafka = "org.apache.spark" %% "spark-sql-kafka-0-10" % sparkVersion
  val sparkAvro = "org.apache.spark" %% "spark-avro" % sparkVersion
  val kafka = "org.apache.kafka" % "kafka_2.11" % kafkaVersion
  val typeSafeConfig = "com.typesafe" % "config" % typeSafeConfigVersion
  val avroHugger = "com.julianpeeters" %% "avrohugger-core" % "1.0.0-RC22"

  //test dependencies
  val scalaTest = "org.scalatest" %% "scalatest" % "3.0.7"
}

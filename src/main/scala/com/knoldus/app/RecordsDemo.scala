package com.knoldus.app

import java.io.File

import com.knoldus.models.Person
import com.knoldus.utils.ConfigManager.AvroConfig
import com.knoldus.utils.Logging
import org.apache.avro.Schema
import org.apache.avro.file.{DataFileReader, DataFileWriter}
import org.apache.avro.generic.{GenericData, GenericDatumReader, GenericDatumWriter, GenericRecord, GenericRecordBuilder}
import org.apache.avro.specific.{SpecificDatumReader, SpecificDatumWriter}

import scala.io.{BufferedSource, Source}

object RecordsDemo extends Logging {

  val personAvroSchemaFilePath = AvroConfig.getValue("person")
  val schemaFile = new File(personAvroSchemaFilePath)

  val parser: Schema.Parser = new Schema.Parser()
  val personSchema: Schema = parser.parse(schemaFile)

  /**
   * To Generate Specific record Code in the schema path
   *
   * @param schemaPath
   */
  def specificRecordCodeGenerate(schemaPath: String): Unit = {
    import avrohugger.Generator
    import avrohugger.format.SpecificRecord
    val mySchemaFile = new File(schemaPath)
    val generator = Generator(SpecificRecord, restrictedFieldNumber = true)
    generator.fileToFile(mySchemaFile)
    logger.info(s"Code generated for schema ${schemaPath}")
  }

  def writeGenericRecordToFile(genericRecord: GenericData.Record, file: File) = {
    val datumWriter = new GenericDatumWriter[GenericData.Record](genericRecord.getSchema)
    try {
      val dataFileWriter = new DataFileWriter[GenericData.Record](datumWriter)
      dataFileWriter.create(genericRecord.getSchema, file)
      dataFileWriter.append(genericRecord)
      dataFileWriter.close()
    } catch {
      case ex: Exception =>
        println(ex.printStackTrace().toString)
        ex.printStackTrace()
    }
  }

  def readGenericRecordFromFile(file: File): Unit = {
    val datumReader = new GenericDatumReader[GenericData.Record]()
    try {
      val dataFileReader = new DataFileReader(file, datumReader)
      while (dataFileReader.hasNext) {
        val readRecord: GenericData.Record = dataFileReader.next()
        println(">>" + readRecord)
      }
    } catch {
      case ex: Exception =>
        println(ex.printStackTrace().toString)
        ex.printStackTrace()
    }
  }

  def main(args: Array[String]): Unit = {

    val myPersonRecordBuilder: GenericRecordBuilder = new GenericRecordBuilder(personSchema)
    myPersonRecordBuilder.set("first_name", "Jack");
    myPersonRecordBuilder.set("last_name", "Hill");
    myPersonRecordBuilder.set("age", 100);
    myPersonRecordBuilder.set("height", 160F);
    myPersonRecordBuilder.set("weight", 55F);
    myPersonRecordBuilder.set("automated_email", false);
    val myRecord: GenericData.Record = myPersonRecordBuilder.build()

    val outputfile = new File("src/main/resources/test-files/person-generic.avro")

    writeGenericRecordToFile(myRecord, outputfile)
    readGenericRecordFromFile(outputfile)

  }
}

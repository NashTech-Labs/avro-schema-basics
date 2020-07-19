/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package com.knoldus.models

import scala.annotation.switch

/**
 * @param first_name First Name of the User
 * @param last_name Last Name of the User
 * @param age Age of the User
 * @param height Height of the User
 * @param weight Weight of the User
 * @param automated_email Indicaton if the user is subscribe to the newsletter
 */
final case class Person(var first_name: String, var last_name: String, var age: Int, var height: Float, var weight: Float, var automated_email: Boolean = true) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("", "", 0, 0.0F, 0.0F, true)
  def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {
        first_name
      }.asInstanceOf[AnyRef]
      case 1 => {
        last_name
      }.asInstanceOf[AnyRef]
      case 2 => {
        age
      }.asInstanceOf[AnyRef]
      case 3 => {
        height
      }.asInstanceOf[AnyRef]
      case 4 => {
        weight
      }.asInstanceOf[AnyRef]
      case 5 => {
        automated_email
      }.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
  def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.first_name = {
        value.toString
      }.asInstanceOf[String]
      case 1 => this.last_name = {
        value.toString
      }.asInstanceOf[String]
      case 2 => this.age = {
        value
      }.asInstanceOf[Int]
      case 3 => this.height = {
        value
      }.asInstanceOf[Float]
      case 4 => this.weight = {
        value
      }.asInstanceOf[Float]
      case 5 => this.automated_email = {
        value
      }.asInstanceOf[Boolean]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
    ()
  }
  def getSchema: org.apache.avro.Schema = Person.SCHEMA$
}

object Person {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Person\",\"namespace\":\"models\",\"fields\":[{\"name\":\"first_name\",\"type\":\"string\",\"doc\":\"First Name of the User\"},{\"name\":\"last_name\",\"type\":\"string\",\"doc\":\"Last Name of the User\"},{\"name\":\"age\",\"type\":\"int\",\"doc\":\"Age of the User\"},{\"name\":\"height\",\"type\":\"float\",\"doc\":\"Height of the User\"},{\"name\":\"weight\",\"type\":\"float\",\"doc\":\"Weight of the User\"},{\"name\":\"automated_email\",\"type\":\"boolean\",\"doc\":\"Indicaton if the user is subscribe to the newsletter\",\"default\":true}]}")
}
package de.htwg.se.htwg_monopoly.model.util

import de.htwg.se.htwg_monopoly.model.fields.{Field, Prices}
import play.api.libs.json.Json

import scala.io.Source

object Util {

  def getFieldFromJSON(jString : String) : Field = {
    val json = Json.parse(jString);
    val name = (json \ "name").as[String];
    val groupName = (json \ "groupName").as[String];
    val price = (json \ "prices").as[Prices];
    val status = (json \ "status").as[String];
    val field = new Field(name, groupName, price);
    field
  }

  def getFileContent(filename: String) : String = {
    val file = Source.fromInputStream(getClass().getClassLoader().getResourceAsStream(filename))
    val filecontent = file.getLines().mkString
    file.close()
    filecontent
  }
}

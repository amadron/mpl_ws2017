package de.htwg.se.htwg_monopoly.model.util

import de.htwg.se.htwg_monopoly.model.fields.{Field, Prices}
import play.api.libs.json.Json

object Util {

  def getFieldFromJSON(jString : String) : Field = {

    val json = Json.parse(jString)

    val name = (json \ "name").as[String]
    val groupName = (json \ "groupName").as[String]
    val prices = (json \ "prices").as[Prices]
    val status = (json \ "status").as[String]
    val field = Field(name, groupName, prices, status)
    field
  }
}

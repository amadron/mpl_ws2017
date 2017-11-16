package de.htwg.se.htwg_monopoly.model.util

import de.htwg.se.htwg_monopoly.model.cards.{Card, Stack}
import de.htwg.se.htwg_monopoly.model.fields.{Field, FieldGroup, Prices, Stations}
import de.htwg.se.htwg_monopoly.model.game.GameField
import play.api.libs.json
import play.api.libs.json.Json

import scala.collection.mutable
import scala.io.Source

object Util {

  def getFieldFromJSON(jString : String) : Field = {
    val json = Json.parse(jString)
    println(json)
    val name = (json \ "name").as[String]
    val groupName = (json \ "groupName").as[String]
    val price = (json \ "prices").as[Prices]
    val  testPrice = (json \ "testPrice").as[Prices]
    val field = Field(name, groupName, price)
    field
  }



  def getFileContent(filename: String) : String = {
    val file = Source.fromInputStream(getClass().getClassLoader().getResourceAsStream(filename))
    val filecontent = file.getLines().mkString
    file.close()
    filecontent
  }

  def getGroups(fieldList: List[Field]) : Array[FieldGroup] = {
    var groupMap = new mutable.HashMap[String, mutable.Set[Field]]() with mutable.MultiMap[String, Field]
    for(field <- fieldList)
      groupMap addBinding(field.groupName, field)
    var groupList = scala.collection.mutable.ListBuffer.empty[FieldGroup]
    groupMap.keys.foreach( (gnames) => {
      val mEntry = groupMap(gnames).toArray[Field]
      val group =  FieldGroup(mEntry)
      groupList += group
    })
    groupList.toArray[FieldGroup]
  }

  def readHTWGMonopoly(): GameField = {
    val fContent = getFileContent("htwg-monopoly.json")
    val json = Json.parse(fContent)
    val rowLength = (json \ "rowLength").as[Int]
    val fieldList = (json \ "fieldList").as[Array[Field]]
    val stations = (json \ "stations").as[Stations]
    val taxesStart = (json \ "taxesStart").as[Int]
    val taxesEnd = (json \ "taxesEnd").as[Int]
    println(stations)
    GameField(rowLength,createCommunityStack(),createEventStack(),getGroups(fieldList.toList),taxesStart,taxesEnd)
  }


  def createCommunityStack(): Stack = {
    val cardArr = scala.collection.mutable.ArrayBuffer.empty[Card]
    for(i <- 1 until 10)
      cardArr += Card(() => {println("Community Card " + i + " Function")})
    Stack(cardArr.toArray)
  }

  def createEventStack(): Stack = {
    val cardArr = scala.collection.mutable.ArrayBuffer.empty[Card]
    for(i <- 1 until 10)
      cardArr += Card(() => {println("Event Card " + i + " Function")})
    Stack(cardArr.toArray)
  }


}

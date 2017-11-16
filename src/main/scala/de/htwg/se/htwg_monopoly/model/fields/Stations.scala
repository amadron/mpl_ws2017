package de.htwg.se.htwg_monopoly.model.fields

case class Stations(names:Array[String],stationPrices:Array[Int], buyPrice:Int, mortgageValue:Int) {
  assert(names.length == 4)
  assert(stationPrices.length == 4)
}

object Stations {
  import play.api.libs.json._
  import play.api.libs.functional.syntax._

  implicit val stationsRead: Reads[Stations] = (
      (JsPath \ "names").read[Array[String]] and
      (JsPath \ "stationPrices").read[Array[Int]] and
      (JsPath \ "buyPrice").read[Int] and
      (JsPath \ "mortgageValue").read[Int]
    )(Stations.apply _)
}
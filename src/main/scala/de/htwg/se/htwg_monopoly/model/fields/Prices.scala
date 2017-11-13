package de.htwg.se.htwg_monopoly.model.fields

case class Prices(buyPrice: Int, rent: Int, monopolyPrice: Int, buyHousePrice: Int, mortgageValue: Int ,housePrices: Array[Int] ) {
  assert(housePrices.length == 5)
}

object Prices {
  import play.api.libs.json._
  import play.api.libs.functional.syntax._

  implicit val pricesRead: Reads[Prices] = (
    (JsPath \ "buyPrice").read[Int] and
    (JsPath \ "rent").read[Int] and
    (JsPath \ "monopolyPrice").read[Int] and
    (JsPath \ "buyHousePrice").read[Int] and
    (JsPath \ "mortgageValue").read[Int] and
    (JsPath \ "housePrices").read[Array[Int]]
    )(Prices.apply _)
}

package de.htwg.se.htwg_monopoly.model.fields

import de.htwg.se.htwg_monopoly.model.util.TestObject
import play.api.libs.json.Reads

case class Prices(buyPrice: Int, monopolyPrice: Int, housePrices: Array[Int]) {


  assert(housePrices.length == 5);
}

object Prices {
  import play.api.libs.json._
  import play.api.libs.functional.syntax._

  implicit val pricesRead: Reads[Prices] = (
    (JsPath \ "buyPrice").read[Int] and
      (JsPath \ "monopolyPrice").read[Int] and
      (JsPath \ "housePrices").read[Array[Int]]
    )(Prices.apply _)
}

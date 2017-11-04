package de.htwg.se.htwg_monopoly.model.util

case class TestObject(name: String, number: Int) {

}

object TestObject {
  import play.api.libs.json._
  import play.api.libs.functional.syntax._

  implicit val locationReads: Reads[TestObject] = (
    (JsPath \ "name").read[String] and
      (JsPath \ "number").read[Int]
    )(TestObject.apply _)
}

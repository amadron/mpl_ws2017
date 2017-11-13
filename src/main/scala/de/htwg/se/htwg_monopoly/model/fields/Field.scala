package de.htwg.se.htwg_monopoly.model.fields
import de.htwg.se.htwg_monopoly.model.fields.FieldStatus._

case class Field(name: String, groupName: String, prices: Prices) {
  var status = Free

  override def toString = {
    name + " " + status
  }
}

object Field {
  import play.api.libs.json._
  import play.api.libs.functional.syntax._

  implicit val fieldRead: Reads[Field] = (
      (JsPath \ "name").read[String] and
      (JsPath \ "groupName").read[String] and
      (JsPath \ "prices").read[Prices]
    )(Field.apply _)
}

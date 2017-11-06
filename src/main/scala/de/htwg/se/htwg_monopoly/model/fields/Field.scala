package de.htwg.se.htwg_monopoly.model.fields
import de.htwg.se.htwg_monopoly.model.fields.FieldStatus._

case class Field(name: String, groupName: String, prices: Prices) {
  var status = Free

  override def toString = {
    name + " " + status
  }
}

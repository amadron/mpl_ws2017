package de.htwg.se.htwg_monopoly.model.game

import de.htwg.se.htwg_monopoly.model.fields.Field

case class Player(name: String) {
  val money: Int = 5000
  val currentFieldIndex = 0
  val ownFields: Array[Field] = new Array[Field](0)

  def isBancrupt(): Boolean = {
    if (money <= 0) {
      var checker = false
      ownFields.foreach((field: Field) => {
        if (field.status != "mortgage") {
          checker = true
        }
      })
      checker
    } else {
      false
    }
  }

  def buyField(field: Field): Unit = {

  }
}

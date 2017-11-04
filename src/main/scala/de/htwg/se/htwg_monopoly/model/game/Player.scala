package de.htwg.se.htwg_monopoly.model.game

import de.htwg.se.htwg_monopoly.model.fields.Field

import scala.collection.mutable.ListBuffer

case class Player(name: String) {
  var money: Int = 5000
  val currentFieldIndex = 0
  var ownFields: ListBuffer[Field] = ListBuffer()

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

  def removeField(field: Field): Unit = {
    ownFields -= field
  }

  def buyField(field: Field): Boolean = {
    if(field.prices.buyPrice <= money) {
      addField(field)
      money -= field.prices.buyPrice
      true
    } else {
      false
    }
  }

  def addField(field:Field): Unit = {
    ownFields.+=:(field)
  }
}

package de.htwg.se.htwg_monopoly.model.game

import de.htwg.se.htwg_monopoly.model.fields.Field

import scala.collection.mutable.ListBuffer

case class Player(name: String, money: Int, currentFieldIndex: Int,ownFields: List[Field]) {

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

  def setField(newField: Int): Player = {
    this.copy(currentFieldIndex = newField)
  }

  def removeField(field: Field): Player = {
    this.copy(ownFields = this.ownFields.filter(!_.equals(field)))
  }

  def buyField(field: Field): Player = {
    if(field.prices.buyPrice <= money) {
      addField(field).copy(money = this.money - field.prices.buyPrice)
    } else {
      null
    }
  }

  def addField(field:Field): Player = {
    this.copy(ownFields = this.ownFields:+ field)
  }
}

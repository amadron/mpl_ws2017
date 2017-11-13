import de.htwg.se.htwg_monopoly.model.fields.{Field, FieldGroup}
import de.htwg.se.htwg_monopoly.model.util.Util
import de.htwg.se.htwg_monopoly.model.util.Util.{getFieldFromJSON, getFileContent, getGroups}

import collection.mutable

object UtilWorksheet {

  val gameField = Util.createGameField()
  println("Size:"+ gameField.eventStack.cards.length)
  gameField.eventStack.cards.foreach((card) => {card.cardFunction()})
  gameField.eventStack
  gameField.fieldGroups
}
package de.htwg.se.htwg_monopoly.model.game

import de.htwg.se.htwg_monopoly.model.cards.Stack
import de.htwg.se.htwg_monopoly.model.fields.FieldGroup

case class GameField(sideRow: Int, communityStack: Stack, eventStack: Stack, fieldGroups: Array[FieldGroup]) {

  def getNumberOfFields(): Int = {
    var result = 0
    for(group <- fieldGroups)
      result += group.fields.length

    return result
  }


}

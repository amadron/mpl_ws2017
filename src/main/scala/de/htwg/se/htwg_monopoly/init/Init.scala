package de.htwg.se.htwg_monopoly.init

import de.htwg.se.htwg_monopoly.controller.Controller
import de.htwg.se.htwg_monopoly.model.cards.{ Card, Stack }
import de.htwg.se.htwg_monopoly.model.fields.{ Field, FieldGroup, Prices }
import de.htwg.se.htwg_monopoly.model.game.{ Game, GameField, Player }
import de.htwg.se.htwg_monopoly.view.tui.Tui

object Init {
  def main(args: Array[String]): Unit = {
    val player1 = Player("Player1")
    val player2 = Player("Player2")
    player1.addField(Field("Fieldname1","grp1",Prices(1,2,Array(1,2,3,4,5))))
    player1.addField(Field("Fieldname2","grp2",Prices(1,2,Array(1,2,3,4,5))))
    val players = Array(player1, player2)
    val cardsCommunity = new Array[Card](2)
    val cardsEvent = new Array[Card](2)
    val communityStack = Stack(cardsCommunity)
    val eventStack = Stack(cardsEvent)
    val groups = new Array[FieldGroup](2)
    val gameField = GameField(4, communityStack, eventStack, groups)
    val game = Game(gameField, players)
    val controller = Controller(game)

    val current = 5
    val maxFieldNo = 6
    val toMove = 3
    println("Rounds: " + controller.getRounds(current, toMove, maxFieldNo))

    val tui: Tui = Tui(controller)
  }
}

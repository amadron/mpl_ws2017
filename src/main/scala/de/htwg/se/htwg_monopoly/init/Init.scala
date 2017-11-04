package de.htwg.se.htwg_monopoly.init

import de.htwg.se.htwg_monopoly.controller.Controller
import de.htwg.se.htwg_monopoly.model.cards.{ Card, Stack }
import de.htwg.se.htwg_monopoly.model.fields.{ Field, FieldGroup, Prices }
import de.htwg.se.htwg_monopoly.model.game.{ Game, GameField, Player }

object Init {
  def main(args: Array[String]): Unit = {
    println("Init 2")
    val player1 = Player("Player1")
    val player2 = Player("Player2")
    val players = Array(player1, player2)
    val cardsCommunity = new Array[Card](2)
    val cardsEvent = new Array[Card](2)
    val communityStack = Stack(cardsCommunity)
    val eventStack = Stack(cardsEvent)
    val groups = new Array[FieldGroup](2)
    val gameField = GameField(4, communityStack, eventStack, groups)
    val game = Game(gameField, players)
    val controller = Controller(game)
  }
}

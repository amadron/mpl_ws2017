package de.htwg.se.htwg_monopoly.init

import de.htwg.se.htwg_monopoly.model.cards.{Card, Stack}
import de.htwg.se.htwg_monopoly.model.fields.{Field, FieldGroup}
import de.htwg.se.htwg_monopoly.model.game.{GameField, Player}


object Init {
  def main(args: Array[String]): Unit = {
    println("Init");
    val player1 = new Player("Player1");
    val player2 = new Player("Player2");
    val players = Array(player1, player2);
    val cardsCommunity = new Array[Card](2);
    val cardsEvent = new Array[Card](2);
    val communityStack = new Stack(cardsCommunity);
    val eventStack = new Stack(cardsEvent);
    val groups = new Array[FieldGroup](2);
    val gameField = new GameField(players, 4,communityStack, eventStack, groups);

  }
}

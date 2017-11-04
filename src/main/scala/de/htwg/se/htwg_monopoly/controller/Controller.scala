package de.htwg.se.htwg_monopoly.controller

import de.htwg.se.htwg_monopoly.model.fields.{Field, Prices}
import de.htwg.se.htwg_monopoly.model.game.{Game, Player}
import play.api.libs.json.{JsValue, Json}

case class Controller(game: Game) {

  def getNoOfBankrupt() : Int = {
    var counter = 0;
    for(player <- game.players if player.isBancrupt())
      counter += 1;
    return counter;
  }

  def isGameFinished(): Boolean = {
    if (getNoOfBankrupt() == game.players.size - 1)
      return true;
    else
      return false;
  }

  def getWinner() : Player = {
    val winnerList = game.players.filter(!_.isBancrupt())
    assert(winnerList.length == 0)
    winnerList(0)
  }

}

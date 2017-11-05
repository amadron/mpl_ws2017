package de.htwg.se.htwg_monopoly.controller

import de.htwg.se.htwg_monopoly.model.game.{Game, Player}

import scala.util.Random

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

  def rollDice() : Int = {
    val random = Random
    random.nextInt(7)
  }

  def getNextFieldToMove(currentField: Int, toMove: Int, maxFields: Int) : Int =
  {
    var nextField = currentField + toMove
    if(nextField > maxFields)
      nextField = nextField - maxFields
    nextField
  }
}

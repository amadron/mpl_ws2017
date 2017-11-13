package de.htwg.se.htwg_monopoly.controller

import de.htwg.se.htwg_monopoly.model.game.{Game, Player}

import scala.util.Random

case class Controller(game: Game) {

  val max_dice_role = 13

  val gameState = GameState.Init

  def getNoOfBankrupt() : Int = {
    var counter = 0
    for(player <- game.players if player.isBancrupt())
      counter += 1
    counter
  }

  def isGameFinished(): Boolean = {
    if (getNoOfBankrupt() == game.players.size - 1) {
      true
    } else {
      false
    }
  }

  def getWinner() : Player = {
    val winnerList = game.players.filter(!_.isBancrupt())
    assert(winnerList.length == 0)
    winnerList(0)
  }

  def letsRoll(): Unit = {
    val roleValue = rollDice()

  }

  def rollDice() : Int = {
    val random = Random
    random.nextInt(max_dice_role) + 1
  }

  def getNextFieldToMove(currentField: Int, toMove: Int, maxFields: Int) : Int =
  {
    (currentField + toMove) % maxFields
  }

  def getRounds(currentField: Int, toMove: Int, maxFields: Int) : Int = {
    (toMove + currentField) /  maxFields
  }

  def getCurrentPlayer(): Player = {
    game.getCurrentPlayer()
  }
}

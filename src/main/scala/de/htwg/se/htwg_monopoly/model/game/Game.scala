package de.htwg.se.htwg_monopoly.model.game

case class Game(gameField: GameField, players: Array[Player]) {
  val currentPlayerIndex: Int = 0

  def getCurrentPlayer(): Player = {
    players(currentPlayerIndex)
  }

}

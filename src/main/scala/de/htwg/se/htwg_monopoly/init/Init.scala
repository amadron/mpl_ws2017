package de.htwg.se.htwg_monopoly.init

import de.htwg.se.htwg_monopoly.controller.Controller
import de.htwg.se.htwg_monopoly.model.util.Util.readHTWGMonopoly
import de.htwg.se.htwg_monopoly.model.fields.{Field, FieldGroup, Prices}
import de.htwg.se.htwg_monopoly.model.game.{Game, GameField, Player}
import de.htwg.se.htwg_monopoly.view.tui.Tui

object Init {
  def main(args: Array[String]): Unit = {
    val player1 = Player("Player1", 5000, 0, List())
    val player2 = Player("Player2", 5000, 0, List())
    player1.addField(Field("Fieldname1","grp1",Prices(1,2,3,4,5,Array(1,2,3,4,5))))
    player1.addField(Field("Fieldname2","grp2",Prices(1,2,3,4,5,Array(1,2,3,4,5))))
    val players = Array(player1, player2)
    val gameField = readHTWGMonopoly()
    println(gameField)
    println("done")
    val game = Game(gameField, players)
    val controller = Controller(game)



    val tui: Tui = Tui(controller)
  }
}

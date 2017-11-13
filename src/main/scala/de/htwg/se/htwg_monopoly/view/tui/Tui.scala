package de.htwg.se.htwg_monopoly.view.tui

import de.htwg.se.htwg_monopoly.controller.{Controller, GameState}
import de.htwg.se.htwg_monopoly.model.fields.Field

case class Tui(controller: Controller) {

  println("Welcome to HTWG-Monopoly!")

  while (true) {
    val state = controller.gameState
    val input = scala.io.StdIn.readLine()
    state match {
      case GameState.Init => getInputForStart(input)
      case GameState.BeforeRoll => getInputForBeforeRoll(input)
      case _ => println("Unknown State" + state)
    }


  }

  def getInputForStart(input: String): Unit = {
    input match {
      case "exit" => System.exit(1)
      case "field.json" => printField()
      case "status" => printStatus()
      case "roll" => controller.letsRoll()
      case _ => println("unknown Command: " + input)
    }
  }

  def getInputForBeforeRoll(input: String): Unit = {
    input match {
      case "exit" => System.exit(1)
      case "field.json" => printField()
      case "status" => printStatus()
      case "roll" => controller.letsRoll()
      case _ => println("unknown Command: " + input)
    }
  }


  def printStatus(): Unit = {
    val player = controller.getCurrentPlayer()
    println("#######################")
    println("Current Player's status:")
    println("Name: " + player.name)
    println("Money: "  + player.money)
    if(player.ownFields.size == 0) {
      println("current player has no fields")
    } else {
      println("Fields:")
      player.ownFields.foreach((field: Field) => {
        println(field)
      })
    }
    println("#######################")
  }

  def printField(): Unit = {
    val player = controller.getCurrentPlayer()
    println("#######################")
    println(player.name + "'s turn")
    println("_______________________")
    println("| | | | | | | | | | | |")
    println("| |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯| |")
    println("| |                 | |")
    println("| |                 | |")
    println("| |                 | |")
    println("| |                 | |")
    println("| |                 | |")
    println("| |                 | |")
    println("| |                 | |")
    println("| |                 | |")
    println("| |_________________| |")
    println("| | | | | | | | | | | |")
    println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯")
    println("#######################")
  }


}

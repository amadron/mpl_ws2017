import de.htwg.se.htwg_monopoly.controller.Controller

val current = 5
val maxFieldNo = 6
val toMove = 0
var controller = Controller(null)
val nextField = (current + toMove) % maxFieldNo


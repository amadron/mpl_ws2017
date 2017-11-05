import de.htwg.se.htwg_monopoly.controller.Controller

val current = 5
val maxFieldNo = 6
val toMove = 3
var controller = Controller(null)
val nextField = controller.getNextFieldToMove(current, toMove, maxFieldNo)


import de.htwg.se.htwg_monopoly.controller.Controller
import de.htwg.se.htwg_monopoly.model.fields.Field
import de.htwg.se.htwg_monopoly.model.util.Util.{getFieldFromJSON, getFileContent, getGroups}

val current = 5
val maxFieldNo = 6
val toMove = 7
var controller = Controller(null)
val nextField = (current + toMove) % maxFieldNo
controller.getRounds(current, toMove, maxFieldNo)




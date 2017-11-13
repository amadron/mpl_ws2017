import de.htwg.se.htwg_monopoly.model.fields.{Field, Prices}
import de.htwg.se.htwg_monopoly.model.game.{Game, Player}


var player = Player("horst", 5000, 0,List[Field]())

val price = Prices(1,2,3,4,Array(1,2,3,4,5))

val field = Field("teststr","testgruppe",price)

player = player.addField(field)
player = player.addField(field)

player.ownFields.size
println("Equals: " + field.equals(field))
player.ownFields.filter(!_.equals(field))
player = player.removeField(field)

player.ownFields.size

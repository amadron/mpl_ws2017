import de.htwg.se.htwg_monopoly.model.fields.{Field, Prices}
import de.htwg.se.htwg_monopoly.model.game.{Game, Player}


val player = Player("horst")

val price = Prices(1,2,Array(1,2,3,4,5))

val field = Field("teststr","testgruppe",price,"owned")

player.addField(field)
player.addField(field)

player.ownFields.size


import de.htwg.se.htwg_monopoly.model.fields.{Field, Prices}
import de.htwg.se.htwg_monopoly.model.fields.FieldStatus._

val price = Prices(1,2,3,4,5,Array(1,2,3,4,5))

val field = Field("teststr","testgruppe",price)

field.toString()
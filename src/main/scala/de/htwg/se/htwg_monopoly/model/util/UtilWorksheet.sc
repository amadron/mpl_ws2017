import de.htwg.se.htwg_monopoly.model.util.Util

object UtilWorksheet {
  val json = "{\n" +
    "\"name\":\"BeneFeld\",\n" +
    "\"groupName\":\"TestGroup\",\n" +
    "\"prices\":\n{\n" +
    "\"buyPrice\":5000,\n" +
    "\"monopolyPrice\":10000,\n" +
    "\"housePrices\":[100,100,100,100,100]\n" +
    "},\n" +
    "\"status\":\"Nope\"\n" +
    "}"
  val field = Util.getFieldFromJSON(json);
  val file = Util.getFileContent("fields/field1")

}
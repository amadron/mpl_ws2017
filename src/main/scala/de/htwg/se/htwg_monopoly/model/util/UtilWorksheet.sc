import de.htwg.se.htwg_monopoly.model.fields.{Field, FieldGroup}
import de.htwg.se.htwg_monopoly.model.util.Util
import de.htwg.se.htwg_monopoly.model.util.Util.{getFieldFromJSON, getFileContent, getGroups}

import collection.mutable

object UtilWorksheet {

  var groupMap = new mutable.HashMap[Int, mutable.Set[Int]]() with mutable.MultiMap[Int, Int]
  groupMap addBinding (1, 1)
  groupMap addBinding (1, 2)
  groupMap addBinding (1, 3)
  groupMap(1).toList

  /*
  val fContent = getFileContent("field")
  val splitStr = fContent.split(";")
  var fieldList = scala.collection.mutable.ListBuffer.empty[Field]
  for(str <- splitStr) {
    //println(str)
    fieldList += getFieldFromJSON(str)
  }
  getGroups(fieldList.toList)
  */
}
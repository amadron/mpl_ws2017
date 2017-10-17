package de.htwg.se.htwg_monopoly.model.game

import de.htwg.se.htwg_monopoly.model.fields.Field

class Player(name: String) {
  var money: Int = 5000;
  var currentFieldIndex = 0;
  var ownFields: Array[Field] = new Array[Field](0);
}

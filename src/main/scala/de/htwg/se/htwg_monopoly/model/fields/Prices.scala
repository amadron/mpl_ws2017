package de.htwg.se.htwg_monopoly.model.fields

case class Prices(buyPrice: Int, monopolyPrice: Int, housePrices: Array[Int]) {
  assert(housePrices.length == 5);
}

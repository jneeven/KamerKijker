package nl.volt.kamerkijker.kkbackend.view

import nl.volt.kamerkijker.kkbackend.jpa.Party
import nl.volt.kamerkijker.kkbackend.jpa.Person

data class PersonView(
  val id: Long?,
  val firstName: String?,
  val lastName: String?,
  val party: Party?
) {
  fun toPerson(): Person {
    return Person(id ?: -1,
      firstName,
      lastName,
      party)
  }
}

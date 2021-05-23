package nl.volt.kamerkijker.kkbackend.view

import nl.volt.kamerkijker.kkbackend.jpa.Party

data class PartyView(
  val id: Long,
  val name: String,
  val code: String?
) {
  fun toParty(): Party {
    return Party(id ?: -1, name, code)
  }
}

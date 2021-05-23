package nl.volt.kamerkijker.kkbackend.view

import nl.volt.kamerkijker.kkbackend.jpa.Motion
import nl.volt.kamerkijker.kkbackend.jpa.Party
import nl.volt.kamerkijker.kkbackend.jpa.Result
import nl.volt.kamerkijker.kkbackend.jpa.Vote

data class VoteView(
  val id: Long?,
  val result: Result?,
  val votes: Int?,
  val motion: Motion?,
  val party: Party?
) {
  fun toVote(): Vote {
    return Vote(id ?: -1, result, votes, motion, party)
  }
}


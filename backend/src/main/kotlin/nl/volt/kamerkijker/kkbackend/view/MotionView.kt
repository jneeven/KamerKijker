package nl.volt.kamerkijker.kkbackend.view

import nl.volt.kamerkijker.kkbackend.jpa.Motion
import java.time.ZonedDateTime

data class MotionView(
  val id: Long?,
  val motieId: Long?,
  val title: String?,
  val submitDate: ZonedDateTime?,
  val voteDate: ZonedDateTime?,
  val document: String?,
  val votesTotal: Int?,
  val firstSignatory: List<PersonView>?,
  val secondSignatory: List<PersonView>?,
  val submitter: List<PersonView>?,
  val coSubmitter: List<PersonView>?,
  val votes: List<VoteView>?,
  val modifiedMotion: MotionView?
) {

  @Throws(IllegalStateException::class)
  fun toMotion(): Motion {
    if (!validate()) {
      throw IllegalStateException(s = "Error converting to Motion")
    }
    return Motion(
      id ?: -1,
      motieId,
      title,
      submitDate,
      voteDate,
      document,
      votesTotal,
      firstSignatory?.map { it.toPerson() },
      secondSignatory?.map { it.toPerson() },
      submitter?.map { it.toPerson() },
      coSubmitter?.map { it.toPerson() },
      votes?.map { it.toVote() },
      modifiedMotion?.toMotion()
    )

  }

  fun validate(): Boolean {
    return true
  }

}

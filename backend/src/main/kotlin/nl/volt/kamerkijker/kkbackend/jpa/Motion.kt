package nl.volt.kamerkijker.kkbackend.jpa

import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "kk_motion")
data class Motion(
  @Id @GeneratedValue
  val id: Long,
  val motieId: Long,

  val title: String,
  val submitDate: ZonedDateTime,
  val voteDate: ZonedDateTime,
  val document: String,
  val votesTotal: Int,

  @OneToOne
  val first_signatory: Person?,

  @OneToOne
  val second_signatory: Person?,

  @OneToOne
  val coSubmitter: Person?,

  @OneToOne
  val submitter: Person,

  @OneToMany
  val votes: List<Vote>,

  @OneToOne
  val modifiedMotion: Motion?
)

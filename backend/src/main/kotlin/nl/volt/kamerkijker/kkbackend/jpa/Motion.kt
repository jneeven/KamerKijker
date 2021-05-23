package nl.volt.kamerkijker.kkbackend.jpa

import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "kk_motion")
data class Motion(
  @Id @GeneratedValue
  val id: Long,
  val motieId: Long?,

  val title: String?,
  val submitDate: ZonedDateTime?,
  val voteDate: ZonedDateTime?,
  val document: String?,
  val votesTotal: Int?,

  @OneToMany
  val firstSignatory: List<Person>?,

  @OneToMany
  val secondSignatory: List<Person>?,

  @OneToMany
  val coSubmitter:  List<Person>?,

  @OneToMany
  val submitter: List<Person>?,

  @OneToMany
  val votes: List<Vote>?,

  @OneToOne
  val modifiedMotion: Motion?
)

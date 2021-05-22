package nl.volt.kamerkijker.kkbackend.jpa

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "kk_party")
data class Party(
  @Id @GeneratedValue
  val id: Long,
  val name: String,
  val code: String
)

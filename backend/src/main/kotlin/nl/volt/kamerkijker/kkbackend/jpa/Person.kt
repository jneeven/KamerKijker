package nl.volt.kamerkijker.kkbackend.jpa

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "kk_person")
data class Person(
  @Id @GeneratedValue
  val id: Long,
  val firstName: String?,
  val lastName: String?,

  @JsonIgnore
  @ManyToOne
  val party: Party?

) {
}

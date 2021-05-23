package nl.volt.kamerkijker.kkbackend.jpa

import javax.persistence.*

@Entity
@Table(name = "kk_vote")
data class Vote (
    @Id @GeneratedValue
    val id: Long,

    @Enumerated(EnumType.STRING)
    val result: Result?,

    val votes: Int?,

    @ManyToOne
    val motion: Motion?,

    @OneToOne
    val party: Party?
    )



enum class Result{
  FOR, AGAINST
}

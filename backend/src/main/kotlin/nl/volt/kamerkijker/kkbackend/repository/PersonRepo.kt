package nl.volt.kamerkijker.kkbackend.repository

import nl.volt.kamerkijker.kkbackend.jpa.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonRepo : JpaRepository<Person, Long> {
  fun findByFirstNameAndLastName(firstName: String?, lastName: String?): Optional<Person>
}

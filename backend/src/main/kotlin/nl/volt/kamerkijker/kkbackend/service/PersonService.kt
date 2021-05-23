package nl.volt.kamerkijker.kkbackend.service

import nl.volt.kamerkijker.kkbackend.jpa.Person
import nl.volt.kamerkijker.kkbackend.repository.PersonRepo
import nl.volt.kamerkijker.kkbackend.view.PersonView
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService {

  @Autowired
  lateinit var personRepo: PersonRepo

  fun findOrCreatePerson(personView: PersonView): Person? {
    val currentPerson: Optional<Person> =
      personRepo.findByFirstNameAndLastName(personView.firstName, personView.lastName)
    return currentPerson.orElse(personRepo.save(personView.toPerson()))
  }


}

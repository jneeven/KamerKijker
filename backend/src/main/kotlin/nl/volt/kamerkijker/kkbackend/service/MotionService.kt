package nl.volt.kamerkijker.kkbackend.service

import nl.volt.kamerkijker.kkbackend.jpa.Motion
import nl.volt.kamerkijker.kkbackend.jpa.Person
import nl.volt.kamerkijker.kkbackend.repository.MotionRepo
import nl.volt.kamerkijker.kkbackend.repository.PersonRepo
import nl.volt.kamerkijker.kkbackend.view.MotionView
import nl.volt.kamerkijker.kkbackend.view.PersonView
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class MotionService {

  @Autowired
  lateinit var motionRepo: MotionRepo

  @Autowired
  lateinit var personService: PersonService

  fun createMotions(motions: List<MotionView>): List<Motion> {
    val motions = motions.map { motion: MotionView ->
      val firstSignatory = motion.firstSignatory?.map { personView: PersonView ->
          personService.findOrCreatePerson(personView)
      }

      val secondSignatory = motion.firstSignatory?.map { personView ->
        personService.findOrCreatePerson(personView)
      }

      val submitter = motion.firstSignatory?.map { personView ->
        personService.findOrCreatePerson(personView)
      }

      val coSubmitter = motion.firstSignatory?.map { personView ->
        personService.findOrCreatePerson(personView)
      }

      val votes = motion.votes?.map { vote ->

        vote
      }
      motion.copy(
        firstSignatory = firstSignatory,
        secondSignatory = secondSignatory,
        submitter = submitter,
        coSubmitter = coSubmitter,
        votes = votes
      )
    }
    val createdMotions: List<Motion> = motions.map { motion -> motionRepo.save(motion.toMotion()) }
    return createdMotions
  }

}

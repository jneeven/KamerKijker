package nl.volt.kamerkijker.kkbackend.controller

import nl.volt.kamerkijker.kkbackend.service.MotionService
import nl.volt.kamerkijker.kkbackend.view.MotionView
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/motions")
class MotionController {

  @Autowired
  lateinit var motionService: MotionService

  @PostMapping()
  fun createMotions(@RequestBody motions: List<MotionView>): ResponseEntity<Any> {
    return try {
      return ResponseEntity.ok(motionService.createMotions(motions))
    } catch (e: IllegalStateException) {
      //      TODO create own validation errors
      ResponseEntity.badRequest().body(e.message)
    }
  }
}

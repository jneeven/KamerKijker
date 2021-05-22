package nl.volt.kamerkijker.kkbackend.api

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.kotlintest.extensions.TestListener
import io.kotlintest.specs.BehaviorSpec
import io.kotlintest.spring.SpringListener
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Profile
import org.springframework.http.HttpHeaders
import java.time.format.DateTimeFormatter

@Profile(*["ci","localci"])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class AbstractITCase : BehaviorSpec() {

  @Autowired
  lateinit var testRestTemplate: TestRestTemplate

  val logger = LoggerFactory.getLogger(this::class.java)
  val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())
  val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSSSSS")

  override fun listeners(): List<TestListener> {
    return listOf(SpringListener)
  }

  val headers = HttpHeaders()

}

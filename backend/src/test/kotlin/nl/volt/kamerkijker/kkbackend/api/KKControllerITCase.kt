package nl.volt.kamerkijker.kkbackend.api

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.test.context.jdbc.SqlGroup
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName


@Profile(*["ci", "localci"])
@SqlGroup(

)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class KKControllerITCase : AbstractITCase() {

  @Test
  @DisplayName("First test")
  fun firstTest() {
    assertEquals(42, 42)
  }


}

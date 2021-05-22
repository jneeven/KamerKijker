package nl.volt.kamerkijker.kkbackend.api


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

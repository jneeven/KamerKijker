package nl.volt.kamerkijker.kkbackend.api
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

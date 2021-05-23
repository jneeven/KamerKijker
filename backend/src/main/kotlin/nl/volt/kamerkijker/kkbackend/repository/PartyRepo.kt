package nl.volt.kamerkijker.kkbackend.repository

import nl.volt.kamerkijker.kkbackend.jpa.Party
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PartyRepo : JpaRepository<Party, Long>

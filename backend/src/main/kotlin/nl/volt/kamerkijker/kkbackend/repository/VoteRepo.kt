package nl.volt.kamerkijker.kkbackend.repository

import nl.volt.kamerkijker.kkbackend.jpa.Vote
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VoteRepo : JpaRepository<Vote, Long>

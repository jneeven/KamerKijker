package nl.volt.kamerkijker.kkbackend.repository

import nl.volt.kamerkijker.kkbackend.jpa.Motion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MotionRepo : JpaRepository<Motion, Long>

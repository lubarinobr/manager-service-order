package br.com.managerorders.repositories

import br.com.managerorders.models.ServiceOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.Instant
import java.time.LocalDate

interface ServiceOrderRepository: JpaRepository<ServiceOrder, Int> {

    @Query("SELECT SUM(so.total) from ServiceOrder so where so.closedAt between ?1 and ?2")
    fun getTotalMonthly(startAt: LocalDate, endedAt: LocalDate): Double?
}
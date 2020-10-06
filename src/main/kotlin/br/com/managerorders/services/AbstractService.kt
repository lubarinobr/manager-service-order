package br.com.managerorders.services

import br.com.managerorders.exceptions.NotFoundEntityException
import br.com.managerorders.models.IEntity
import org.springframework.data.jpa.repository.JpaRepository

abstract class AbstractService<E : IEntity>(
    var repository: JpaRepository<E, Int>
) {

    fun findAll() : List<E> {
        return repository.findAll()
    }

    fun findById(id: Int) : E {
        return repository
            .findById(id)
            .orElseThrow { NotFoundEntityException() }
    }

    fun save(entity: E) {
        repository.save(entity)
    }

    fun deleteById(id: Int) {
        repository.deleteById(id)
    }
}
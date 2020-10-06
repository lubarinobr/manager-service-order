package br.com.managerorders.services

import br.com.managerorders.models.IEntity

interface Service<E: IEntity> {

    fun findAll(): List<E>
    fun findById(id: Int): E
    fun save(entity: E)
    fun deleteById(id: Int)
}
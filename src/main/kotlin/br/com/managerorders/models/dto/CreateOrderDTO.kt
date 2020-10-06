package br.com.managerorders.models.dto

import br.com.managerorders.models.ServiceOrder

data class CreateOrderDTO(
    val id: Int?,
    val description: String,
    val equipment: String,
    val userId: Int?,
    val status: ServiceOrder.Status?
) {
    constructor() : this (null,"", "", null, ServiceOrder.Status.PENDENTE)
}

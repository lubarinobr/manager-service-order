package br.com.managerorders.models.dto

import br.com.managerorders.models.ServiceOrder

data class OrderResponseDTO(
    val id: Int,
    val user: String,
    val status: String
) {
    companion object {
        fun from(serviceOrder: ServiceOrder) = OrderResponseDTO(
            serviceOrder.id!!,
            serviceOrder.user?.name!!,
            serviceOrder.status!!.value
        )
    }
}

package br.com.managerorders.services

import br.com.managerorders.models.ServiceOrder
import br.com.managerorders.models.dto.CreateOrderDTO
import br.com.managerorders.models.dto.OrderResponseDTO

interface ServiceOrderService: Service<ServiceOrder> {

    fun createOrder(createOrderDTO: CreateOrderDTO)

    fun listOrder(): List<OrderResponseDTO>
    fun startEdit(id: Int): CreateOrderDTO
    fun edit(createOrderDTO: CreateOrderDTO)

    fun getAllServiceOrderMonthly()
}
package br.com.managerorders.services

import br.com.managerorders.models.ServiceOrder
import br.com.managerorders.models.dto.CreateOrderDTO
import br.com.managerorders.models.dto.OrderResponseDTO
import br.com.managerorders.repositories.ServiceOrderRepository
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.time.YearMonth
import java.time.ZoneId
import java.util.Calendar

@Service
class ServiceOrderServiceImpl(
    private val serviceOrderRepository: ServiceOrderRepository,
    private val userService: UserService
): AbstractService<ServiceOrder>(serviceOrderRepository), ServiceOrderService {

    override fun createOrder(createOrderDTO: CreateOrderDTO) {
        val result = userService.findById(createOrderDTO.userId!!)

        val order = ServiceOrder().apply {
            user = result
            description = createOrderDTO.description
            equipment = createOrderDTO.equipment
            status = ServiceOrder.Status.PENDENTE
        }

        serviceOrderRepository.save(order)
    }

    override fun listOrder(): List<OrderResponseDTO> {
        val orders = serviceOrderRepository.findAll()

        return orders
            .map {
                OrderResponseDTO.from(it)
            }
            .toList()
    }

    override fun startEdit(id: Int): CreateOrderDTO {
        val serviceOrder = serviceOrderRepository.findById(id).get()
        return CreateOrderDTO(
            serviceOrder.id,
            serviceOrder.description!!,
            serviceOrder.equipment!!,
            serviceOrder.user?.id,
            serviceOrder.status
        )
    }

    override fun edit(createOrderDTO: CreateOrderDTO) {
        val result = userService.findById(createOrderDTO.userId!!)
        val serviceOrder = ServiceOrder().apply {
            id = createOrderDTO.id
            description = createOrderDTO.description
            equipment = createOrderDTO.equipment
            user = result
            status = createOrderDTO.status!!
        }

        serviceOrderRepository.save(serviceOrder)
    }

    override fun getAllServiceOrderMonthly() {
        val dates = YearMonth
            .from(
                Instant
                    .now()
                    .atZone(ZoneId.of("America/Sao_Paulo"))
            )

        val x = LocalDateTime.now()

        Calendar.DAY_OF_MONTH

        val result = serviceOrderRepository.getTotalMonthly(dates.atDay(1), dates.atEndOfMonth())

        //print(result)

        val calendar = Calendar.getInstance()

        calendar.add(Calendar.DAY_OF_MONTH, 1)

        print(calendar.get(Calendar.DAY_OF_MONTH))
    }

}

package br.com.managerorders.controllers

import br.com.managerorders.models.ServiceOrder
import br.com.managerorders.models.dto.CreateOrderDTO
import br.com.managerorders.services.ServiceOrderService
import br.com.managerorders.services.UserService
import org.springframework.beans.propertyeditors.StringTrimmerEditor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Controller
@RequestMapping("/service-order")
class ServiceOrderController(
    private val serviceServiceOrder: ServiceOrderService,
    private val userService: UserService
): AbstractController<ServiceOrder>(serviceServiceOrder) {

    @InitBinder
    fun initBinder(webDataBinder: WebDataBinder) {
        webDataBinder.registerCustomEditor(String::class.java, StringTrimmerEditor(true))
    }

    @GetMapping
    fun findAllPage(model: Model): String {
        val result = serviceServiceOrder.listOrder()
        model.addAttribute("serviceOrders", result)
        return "order/list-orders.html"
    }

    @GetMapping("/add")
    fun newUserIndex(model: Model): String {
        model.addAttribute("serviceOrder", CreateOrderDTO())
        model.addAttribute("users", userService.findAll())
        return "order/add-order.html"
    }

    @PostMapping("/add")
    fun createOrder(
        @Valid @ModelAttribute("serviceOrder") createOrderDTO: CreateOrderDTO,
        bindingResult: BindingResult
    ): String {
        if (bindingResult.hasErrors()) {
            return "order/add-order.html"
        }
        serviceServiceOrder.createOrder(createOrderDTO)
        return "redirect:/service-order"
    }

    @GetMapping("/edit/{id}")
    fun editServiceOrder(
        @PathVariable("id") id: Int,
        model: Model
    ): String {
        val serviceOrder = serviceServiceOrder.startEdit(id)
        model.addAttribute("users", userService.findAll())
        model.addAttribute("serviceOrder", serviceOrder)
        model.addAttribute("status", ServiceOrder.Status.values())
        return "order/edit-order.html"
    }

    @PostMapping("/edit")
    fun editServiceOrder(
        @Valid @ModelAttribute("serviceOrder") createOrderDTO: CreateOrderDTO,
        bindingResult: BindingResult
    ): String {
        if (bindingResult.hasErrors()) {
            return "order/edit-order.html"
        }
        serviceServiceOrder.edit(createOrderDTO)
        return "redirect:/service-order"
    }

    @GetMapping("/print/{id}")
    fun printServiceOrder(
            @PathVariable("id") id: Int,
            model: Model
    ): String {
        print("Teste print: $id\n")
        model.addAttribute("serviceOrder", CreateOrderDTO())
        return "order/print-order.html"
    }

}
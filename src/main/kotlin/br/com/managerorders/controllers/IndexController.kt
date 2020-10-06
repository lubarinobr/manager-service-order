package br.com.managerorders.controllers

import br.com.managerorders.services.ServiceOrderService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController(
    private val serviceOrderService: ServiceOrderService
) {

    @GetMapping("/")
    fun index(model: Model): String {
        serviceOrderService.getAllServiceOrderMonthly()
        return "index"
    }
}
package br.com.managerorders.controllers

import br.com.managerorders.models.User
import br.com.managerorders.services.Service
import org.springframework.beans.propertyeditors.StringTrimmerEditor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Controller
@RequestMapping("/user")
class UserController(
    service: Service<User>
): AbstractController<User>(service) {

    @InitBinder
    fun initBinder(webDataBinder: WebDataBinder) {
        webDataBinder.registerCustomEditor(String::class.java, StringTrimmerEditor(true))
    }

    @GetMapping
    fun findAllPage(model: Model): String {
        val result = service.findAll()
        model.addAttribute("users", result)
        return "user/list-user.html"
    }

    @GetMapping("/add")
    fun newUserIndex(model: Model): String {
        model.addAttribute("user", User())
        return "user/add-user.html"
    }

    @PostMapping("/add")
    fun saveUser(@Valid @ModelAttribute("user") user: User, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) {
            return "user/add-user.html"
        }
        service.save(user)
        return "redirect:/user"
    }

    @GetMapping("/{id}/delete")
    fun deleteUser(
        @PathVariable("id") id: Int
    ): String {
        service.deleteById(id)
        return "redirect:/user"
    }
}

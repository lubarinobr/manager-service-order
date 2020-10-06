package br.com.managerorders.controllers

import br.com.managerorders.models.IEntity
import br.com.managerorders.services.Service
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

abstract class AbstractController<E: IEntity>(
    var service: Service<E>
)

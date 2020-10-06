package br.com.managerorders.services

import br.com.managerorders.models.User
import br.com.managerorders.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(repository: UserRepository) : AbstractService<User>(repository), UserService

package br.com.managerorders.repositories

import br.com.managerorders.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int>

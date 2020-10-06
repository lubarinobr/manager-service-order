package br.com.managerorders.models

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
class User: IEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    var id: Int? = null
    @NotEmpty(message = "O nome não pode ser vazio")
    @Size(min = 3, max = 40)
    var name: String? = null
    var surname: String? = null
    @NotEmpty(message = "O telefone não pode ser vazio")
    var phone: String? = null
    @Column(unique = true)
    @Email
    @NotEmpty(message = "O email não pode ser vazio")
    var email: String? = null

    override fun getIdentification(): Int {
        return id!!
    }
}

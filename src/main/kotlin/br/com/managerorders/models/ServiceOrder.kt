package br.com.managerorders.models

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.time.LocalDate
import javax.persistence.*

@Entity
class ServiceOrder: IEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    var id: Int? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null

    var description: String? = null
    var equipment: String? = null

    @CreationTimestamp
    var createdAt: Instant? = null

    @UpdateTimestamp
    var updatedAt: Instant? = null

    @Enumerated(value = EnumType.STRING)
    var status: Status = Status.PENDENTE

    var total: Double = 0.0

    var closedAt: LocalDate? = null

    enum class Status(val value: String) {
        PENDENTE("PENDENTE"),
        EM_MANUTENCAO("EM MANUTENÇÃO"),
        AGUARDANDO_LIBERACAO_CLIENTE("AGUARDANDO LIBERAÇÃO CLIENTE"),
        AGUARDANDO_LIBERACAO_BANCADA("AGUARDADO LIBERAÇÃO BANCADA"),
        ENTREGUE("ENTREGUE"),
        CANCELADA("CANCELADA");

    }

    override fun getIdentification(): Int {
        return id!!
    }

}

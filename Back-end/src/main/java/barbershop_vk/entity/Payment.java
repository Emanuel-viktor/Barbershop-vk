package barbershop_vk.entity;

import barbershop_vk.enums.PaymentMethod;
import barbershop_vk.enums.StatusPayment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
@Setter
@Getter
@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int value;
    @Enumerated(EnumType.STRING)
    private PaymentMethod PaymentMethod ;
    @Enumerated(EnumType.STRING)
    private StatusPayment StatusPayment ;

    @JsonBackReference("payment-scheduling")
    @OneToOne
    @JoinColumn(name = "scheduling_id")
    private Scheduling scheduling;

    public Payment() {
    }

    public Payment(Long id, int value, PaymentMethod paymentMethod, StatusPayment statusPayment, Scheduling scheduling) {
        this.id = id;
        this.value = value;
        PaymentMethod = paymentMethod;
        StatusPayment = statusPayment;
        this.scheduling = scheduling;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

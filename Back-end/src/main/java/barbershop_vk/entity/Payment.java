package barbershop_vk.entity;

import barbershop_vk.enums.PaymentMethod;
import barbershop_vk.enums.StatusPayment;
import jakarta.persistence.*;

import java.util.Objects;
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int value;
    @Enumerated(EnumType.STRING)
    private PaymentMethod PaymentMethod ;
    @Enumerated(EnumType.STRING)
    private StatusPayment StatusPayment ;

    @OneToOne(mappedBy = "payment")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public PaymentMethod getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    public StatusPayment getStatusPayment() {
        return StatusPayment;
    }

    public void setStatusPayment(StatusPayment statusPayment) {
        StatusPayment = statusPayment;
    }

    public Scheduling getScheduling() {
        return scheduling;
    }
    public void setScheduling(Scheduling scheduling) {
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

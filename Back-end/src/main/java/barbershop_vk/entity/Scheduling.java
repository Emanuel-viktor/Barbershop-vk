package barbershop_vk.entity;

import barbershop_vk.enums.SchedulingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "tb_scheduling")
public class Scheduling implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate appointmentDate;
    private LocalTime scheduledTime;
    private LocalTime startTime;
    private LocalTime endTime;
    private String observation;
    @Enumerated(EnumType.STRING)
    private SchedulingStatus status;
    private Integer queueOrder;
    private LocalDateTime createdAt;

    //ESTA REPETINDO QUANDO COLOCA NO POSTMAN , SEM FIM (AJUSTAR)
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "barber_service_id")
    private BarberService service;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public Scheduling() {
    }

    public Scheduling(Long id, LocalDate appointmentDate, LocalTime scheduledTime, LocalTime startTime, LocalTime endTime, String observation, SchedulingStatus status, Integer queueOrder, LocalDateTime createdAt, User client, Barber barber, BarberService service, Payment payment) {

        this.id = id;
        this.appointmentDate = appointmentDate;
        this.scheduledTime = scheduledTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.observation = observation;
        this.status = status;
        this.queueOrder = queueOrder;
        this.createdAt = createdAt;
        this.client = client;
        this.barber = barber;
        this.service = service;
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Scheduling that = (Scheduling) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

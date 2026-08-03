package barbershop_vk.entity;

import barbershop_vk.enums.SchedulingStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Scheduling {

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

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Scheduling() {
    }

    public Scheduling(Long id,   LocalDate appointmentDate, LocalTime scheduledTime, LocalTime startTime, LocalTime endTime, String observation, SchedulingStatus status, Integer queueOrder, LocalDateTime createdAt, User client) {

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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public SchedulingStatus getStatus() {
        return status;
    }

    public void setStatus(SchedulingStatus status) {
        this.status = status;
    }

    public Integer getQueueOrder() {
        return queueOrder;
    }

    public void setQueueOrder(Integer queueOrder) {
        this.queueOrder = queueOrder;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
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

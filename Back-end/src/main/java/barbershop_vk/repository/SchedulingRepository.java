package barbershop_vk.repository;

import barbershop_vk.entity.Scheduling;
import barbershop_vk.enums.SchedulingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
    List<Scheduling> findByBarberIdAndAppointmentDateAndStatusInOrderByQueueOrderAsc(
            Long barberId,
            LocalDate appointmentDate,
            List<SchedulingStatus> statuses
    );
}

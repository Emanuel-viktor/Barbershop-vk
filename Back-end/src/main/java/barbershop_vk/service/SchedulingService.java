package barbershop_vk.service;

import barbershop_vk.entity.Scheduling;
import barbershop_vk.enums.SchedulingStatus;
import barbershop_vk.repository.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;

    public List<Scheduling> findAll() {
        return schedulingRepository.findAll();
    }

    public List<Scheduling> findQueue(
            Long barberId,
            LocalDate appointmentDate
    ) {
        return schedulingRepository
                .findByBarberIdAndAppointmentDateAndStatusInOrderByQueueOrderAsc(
                        barberId,
                        appointmentDate,
                        List.of(
                                SchedulingStatus.AGENDADO,
                                SchedulingStatus.ANDAMENTO
                        )
                );
    }

    public Scheduling insert(Scheduling scheduling) {
        return schedulingRepository.save(scheduling);
    }

    public void delete(Long id){
        schedulingRepository.deleteById(id);
    }


}

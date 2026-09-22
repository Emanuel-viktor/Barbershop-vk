package barbershop_vk.service;

import barbershop_vk.entity.Scheduling;
import barbershop_vk.enums.SchedulingStatus;
import barbershop_vk.repository.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import barbershop_vk.dto.QueuePositionRequest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @Transactional
    public Scheduling updateQueuePosition(
            Long schedulingId,
            QueuePositionRequest request
    ) {

        Scheduling scheduling = schedulingRepository.findById(schedulingId)
                .orElseThrow(() ->
                        new RuntimeException("Agendamento não encontrado")
                );

        Integer oldPosition = scheduling.getQueueOrder();
        Integer newPosition = request.getQueueOrder();

        if (newPosition == null || newPosition < 1) {
            throw new RuntimeException("Posição inválida");
        }

        if (oldPosition.equals(newPosition)) {
            return scheduling;
        }

        if (newPosition < oldPosition) {

            List<Scheduling> schedulings =
                    schedulingRepository
                            .findByBarberIdAndAppointmentDateAndStatusInOrderByQueueOrderAsc(
                                    scheduling.getBarber().getId(),
                                    scheduling.getAppointmentDate(),
                                    List.of(
                                            SchedulingStatus.AGENDADO,
                                            SchedulingStatus.ANDAMENTO
                                    )
                            );

            for (Scheduling item : schedulings) {

                if (item.getId().equals(scheduling.getId())) {
                    continue;
                }

                if (item.getQueueOrder() >= newPosition
                        && item.getQueueOrder() < oldPosition) {

                    item.setQueueOrder(item.getQueueOrder() + 1);
                    schedulingRepository.save(item);
                }
            }

        } else {

            List<Scheduling> schedulings =
                    schedulingRepository
                            .findByBarberIdAndAppointmentDateAndStatusInOrderByQueueOrderAsc(
                                    scheduling.getBarber().getId(),
                                    scheduling.getAppointmentDate(),
                                    List.of(
                                            SchedulingStatus.AGENDADO,
                                            SchedulingStatus.ANDAMENTO
                                    )
                            );

            for (Scheduling item : schedulings) {

                if (item.getId().equals(scheduling.getId())) {
                    continue;
                }

                if (item.getQueueOrder() > oldPosition
                        && item.getQueueOrder() <= newPosition) {

                    item.setQueueOrder(item.getQueueOrder() - 1);
                    schedulingRepository.save(item);
                }
            }
        }

        scheduling.setQueueOrder(newPosition);

        return schedulingRepository.save(scheduling);
    }
    @Transactional
    public Scheduling startScheduling(Long id) {

        Scheduling scheduling = schedulingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Agendamento não encontrado")
                );

        if (scheduling.getStatus() != SchedulingStatus.AGENDADO) {
            throw new RuntimeException(
                    "Somente agendamentos podem ser iniciados"
            );
        }

        scheduling.setStatus(SchedulingStatus.ANDAMENTO);
        scheduling.setStartTime(LocalTime.now());

        return schedulingRepository.save(scheduling);
    }


}

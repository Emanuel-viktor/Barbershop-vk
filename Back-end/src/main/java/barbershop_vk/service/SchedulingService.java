package barbershop_vk.service;

import barbershop_vk.entity.Scheduling;
import barbershop_vk.enums.SchedulingStatus;
import barbershop_vk.repository.BarberServiceRepository;
import barbershop_vk.repository.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import barbershop_vk.dto.QueuePositionRequest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private BarberServiceRepository barberServiceRepository;

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
    @Transactional
    public Scheduling finishScheduling(Long id) {

        Scheduling scheduling = schedulingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Agendamento não encontrado")
                );

        if (scheduling.getStatus() != SchedulingStatus.ANDAMENTO) {
            throw new RuntimeException(
                    "Somente atendimentos em andamento podem ser finalizados"
            );
        }

        scheduling.setStatus(SchedulingStatus.FINALIZADO);
        scheduling.setEndTime(LocalTime.now());

        return schedulingRepository.save(scheduling);
    }

    public List<LocalTime> getAvailableTimes(
            Long barberId,
            Long serviceId,
            LocalDate date
    ) {

        barbershop_vk.entity.BarberService barberService = barberServiceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        int duration = barberService.getDuration();

        List<Scheduling> schedulings =
                schedulingRepository.findByBarberIdAndAppointmentDateAndStatusIn(
                        barberId,
                        date,
                        List.of(
                                SchedulingStatus.AGENDADO,
                                SchedulingStatus.ANDAMENTO
                        )
                );

        List<LocalTime> available = new ArrayList<>();

        LocalTime current = LocalTime.of(8, 0);

        while (current.isBefore(LocalTime.of(18, 0))) {

            LocalTime end = current.plusMinutes(duration);

            // pula horário de almoço
            if (current.isBefore(LocalTime.of(13, 0))
                    && end.isAfter(LocalTime.of(12, 0))) {

                current = current.plusMinutes(15);
                continue;
            }

            // não deixa passar das 18h
            if (end.isAfter(LocalTime.of(18, 0))) {
                break;
            }

            boolean occupied = false;

            for (Scheduling scheduling : schedulings) {

                int occupiedDuration =
                        scheduling.getService().getDuration();

                LocalTime occupiedStart =
                        scheduling.getScheduledTime();

                LocalTime occupiedEnd =
                        occupiedStart.plusMinutes(occupiedDuration);

                if (current.isBefore(occupiedEnd)
                        && end.isAfter(occupiedStart)) {

                    occupied = true;
                    break;
                }
            }

            if (!occupied) {
                available.add(current);
            }

            current = current.plusMinutes(15);
        }

        return available;
    }

}

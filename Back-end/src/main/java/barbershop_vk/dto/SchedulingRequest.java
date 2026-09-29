package barbershop_vk.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class SchedulingRequest {

    private Long clientId;
    private Long barberId;
    private Long serviceId;

    private LocalDate appointmentDate;
    private LocalTime scheduledTime;

    private String observation;
}
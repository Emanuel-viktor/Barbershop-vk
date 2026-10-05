package barbershop_vk.service;

import barbershop_vk.dto.PaymentRequest;
import barbershop_vk.entity.Payment;
import barbershop_vk.entity.Scheduling;
import barbershop_vk.repository.PaymentRepository;
import barbershop_vk.repository.SchedulingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {


    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Transactional
    public Payment createPayment(Long schedulingId, PaymentRequest request) {

        Scheduling scheduling = schedulingRepository.findById(schedulingId)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        if (scheduling.getPayment() != null) {
            throw new RuntimeException("Este agendamento já possui um pagamento.");
        }

        Payment payment = new Payment();

        payment.setValue(scheduling.getService().getPrice());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setStatusPayment(
                barbershop_vk.enums.StatusPayment.APROVADO
        );
        payment.setScheduling(scheduling);

        return paymentRepository.save(payment);
    }
}
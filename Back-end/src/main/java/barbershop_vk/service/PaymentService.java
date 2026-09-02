package barbershop_vk.service;

import barbershop_vk.entity.Payment;
import barbershop_vk.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment insert(Payment payment) {
        return paymentRepository.save(payment);
    }
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }
}

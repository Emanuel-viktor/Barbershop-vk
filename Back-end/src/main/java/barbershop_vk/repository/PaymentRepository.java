package barbershop_vk.repository;

import barbershop_vk.entity.Payment;
import barbershop_vk.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

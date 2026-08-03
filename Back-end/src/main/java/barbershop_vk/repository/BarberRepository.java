package barbershop_vk.repository;

import barbershop_vk.entity.Barber;
import barbershop_vk.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Long> {
}

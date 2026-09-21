package barbershop_vk.repository;

import barbershop_vk.entity.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
    List<Scheduling> findAllByOrderByQueueOrderAsc();
}

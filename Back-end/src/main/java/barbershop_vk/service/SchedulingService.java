package barbershop_vk.service;

import barbershop_vk.entity.Scheduling;
import barbershop_vk.repository.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;

    public List<Scheduling> findAll() {
        return schedulingRepository.findAll();
    }


}

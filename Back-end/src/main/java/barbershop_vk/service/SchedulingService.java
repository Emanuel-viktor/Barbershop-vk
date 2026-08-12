package barbershop_vk.service;

import barbershop_vk.repository.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;


}

package barbershop_vk.resources;

import barbershop_vk.repository.SchedulingRepository;
import barbershop_vk.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scheduling")
public class SchedulingResources {

    @Autowired
    private SchedulingService schedulingService;

    @Autowired
    private SchedulingRepository schedulingRepository;
}

package barbershop_vk.controller;

import barbershop_vk.entity.Scheduling;
import barbershop_vk.repository.SchedulingRepository;
import barbershop_vk.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/scheduling")
public class SchedulingController {

    @Autowired
    private SchedulingService schedulingService;

    @GetMapping
    public List<Scheduling> findAll() {
        return schedulingService.findAll();
    }


}

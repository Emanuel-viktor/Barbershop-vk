package barbershop_vk.resources;

import barbershop_vk.repository.BarberRepository;
import barbershop_vk.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/barbers")
public class BarberResources {

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private BarberService barberService;
}

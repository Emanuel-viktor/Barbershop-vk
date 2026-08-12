package barbershop_vk.resources;

import barbershop_vk.repository.ServiceRepository;
import barbershop_vk.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/services")
public class ServiceResources {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    ServiceService serviceService;
}

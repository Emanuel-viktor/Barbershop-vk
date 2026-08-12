package barbershop_vk.controller;

import barbershop_vk.entity.BarberService;
import barbershop_vk.service.BarberServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class BarberServiceController {


    @Autowired
   private BarberServiceService BarberServiceService;

    @GetMapping
    public List<BarberService> findAll() {
        return BarberServiceService.findAll();
    }
}

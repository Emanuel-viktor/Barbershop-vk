package barbershop_vk.controller;

import barbershop_vk.entity.Barber;
import barbershop_vk.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/barbers")
public class BarberController {

    @Autowired
    private BarberService barberService;

    @GetMapping
    private List<Barber> findAll() {
        return barberService.findAll();
    }

    @PostMapping
    public Barber createBarber(@RequestBody Barber barber) {
        barber=barberService.insertBarber(barber);
        return barber;
    }
}

package barbershop_vk.controller;

import barbershop_vk.entity.BarberService;
import barbershop_vk.service.BarberServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public BarberService createBarberService(@RequestBody BarberService barberService) {
        barberService=BarberServiceService.insert(barberService);
        return barberService;
    }
    @DeleteMapping
    public void deleteBarberService(@RequestBody Long id) {
        BarberServiceService.deleteBarberService(id);
    }

}

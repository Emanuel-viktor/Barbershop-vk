package barbershop_vk.controller;

import barbershop_vk.dto.BarberLoginRequest;
import barbershop_vk.dto.LoginResponse;
import barbershop_vk.entity.Barber;
import barbershop_vk.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/barbers")
public class BarberController {

    @Autowired
    private BarberService barberService;

    @GetMapping
    @PreAuthorize("hasRole('BARBEIRO')")
    public List<Barber> findAll() {
        return barberService.findAll();
    }

    @PostMapping
    public Barber createBarber(@RequestBody Barber barber) {
        barber = barberService.insertBarber(barber);
        return barber;
    }

    @DeleteMapping
    public void deleteBarber(@RequestBody Long id) {
        barberService.deleteBarberService(id);
    }

    @PutMapping
    public Barber updateBarber(@PathVariable Long id, @RequestBody Barber barber) {
        return barberService.updateBarber(id, barber);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody BarberLoginRequest loginRequest
    ) {
        return barberService.login(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );
    }
}

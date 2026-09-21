package barbershop_vk.service;

import barbershop_vk.dto.LoginResponse;
import barbershop_vk.entity.Barber;
import barbershop_vk.repository.BarberRepository;
import barbershop_vk.security.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberService {

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    public List<Barber> findAll() {
        return barberRepository.findAll();
    }

    public Barber insertBarber(Barber barber) {
        return barberRepository.save(barber);
    }

    public void deleteBarberService(Long id) {
        barberRepository.deleteById(id);
    }

    public Barber updateBarber(Long id, Barber barber) {
        Barber entity = barberRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario nao encontrado"));

        entity.setName(barber.getName());
        entity.setEmail(barber.getEmail());
        entity.setPassword(barber.getPassword());

        return barberRepository.save(entity);
    }
    public LoginResponse login(String email, String password) {

        Barber barber = barberRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("E-mail ou senha inválidos")
                );

        if (!passwordEncoder.matches(password, barber.getPassword())) {
            throw new RuntimeException("E-mail ou senha inválidos");
        }

        String token = jwtService.generateToken(
                barber.getId(),
                "BARBEIRO"
        );

        return new LoginResponse(
                barber.getId(),
                barber.getName(),
                barber.getEmail(),
                token
        );
    }


}

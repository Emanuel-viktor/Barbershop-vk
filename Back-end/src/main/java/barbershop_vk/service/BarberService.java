package barbershop_vk.service;

import barbershop_vk.entity.Barber;
import barbershop_vk.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberService {

    @Autowired
    private BarberRepository barberRepository;

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


}

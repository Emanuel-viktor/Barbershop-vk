package barbershop_vk.service;

import barbershop_vk.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarberService {

    @Autowired
    private BarberRepository barberRepository;
}

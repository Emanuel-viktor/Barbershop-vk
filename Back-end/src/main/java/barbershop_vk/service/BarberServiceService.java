package barbershop_vk.service;

import barbershop_vk.entity.BarberService;
import barbershop_vk.repository.BarberServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberServiceService {

    @Autowired
    private BarberServiceRepository BarberServiceRepository;

    public List<BarberService> findAll() {
        return BarberServiceRepository.findAll();}

        public BarberService insert(BarberService barberService) {
        return BarberServiceRepository.save(barberService);
        }
    }

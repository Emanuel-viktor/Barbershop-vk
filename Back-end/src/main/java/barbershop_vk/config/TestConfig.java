package barbershop_vk.config;

import barbershop_vk.entity.*;
import barbershop_vk.enums.PaymentMethod;
import barbershop_vk.enums.StatusPayment;
import barbershop_vk.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BarberServiceRepository serviceRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private SchedulingRepository schedulingRepository;
    @Autowired
    private BarberRepository barberRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 =new User(null,"Viktor","viktor@gmail.com","123","9332424342",null);

        userRepository.save(u1);

        Barber b1=new Barber(null,"PEDRO","Pedro@gmail.com","1234","833384343","melhor da regiao",null);

        barberRepository.save(b1);

        Payment p1=new Payment(null,20, PaymentMethod.CREDITO, StatusPayment.APROVADO,null);
        paymentRepository.save(p1);

        BarberService s1=new BarberService("degrade",null,"corte moderno",null,20);
        serviceRepository.save(s1);

        Scheduling sc=new Scheduling(null,null,null,null,null,null,null,null,null,null,null,null,null);
        schedulingRepository.save(sc);
    }


}

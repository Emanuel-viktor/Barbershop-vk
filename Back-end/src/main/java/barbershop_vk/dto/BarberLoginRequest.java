package barbershop_vk.dto;

import lombok.Getter;
import lombok.Setter;


    @Getter
    @Setter
    public class BarberLoginRequest {

        private String email;
        private String password;
    }


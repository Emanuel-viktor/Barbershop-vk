package barbershop_vk.dto;

import barbershop_vk.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {

    private PaymentMethod paymentMethod;
}
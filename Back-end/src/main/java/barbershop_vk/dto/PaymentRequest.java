package barbershop_vk.dto;

import barbershop_vk.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {

    @NotNull(message = "O método de pagamento é obrigatório.")
    private PaymentMethod paymentMethod;
}
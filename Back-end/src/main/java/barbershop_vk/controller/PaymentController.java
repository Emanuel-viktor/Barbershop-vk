package barbershop_vk.controller;

import barbershop_vk.dto.PaymentRequest;
import barbershop_vk.entity.Payment;
import barbershop_vk.repository.PaymentRepository;
import barbershop_vk.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/{schedulingId}")
    public Payment createPayment(
            @PathVariable Long schedulingId,
            @RequestBody PaymentRequest request) {

        return paymentService.createPayment(schedulingId, request);
    }
}
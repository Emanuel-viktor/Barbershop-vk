package barbershop_vk.controller;

import barbershop_vk.dto.PaymentRequest;
import barbershop_vk.entity.Payment;
import barbershop_vk.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/{schedulingId}")
    @PreAuthorize("hasRole('BARBEIRO')")
    public Payment createPayment(
            @PathVariable Long schedulingId,
            @RequestBody PaymentRequest request) {

        return paymentService.createPayment(schedulingId, request);
    }
}
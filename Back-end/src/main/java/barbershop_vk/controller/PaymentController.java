package barbershop_vk.controller;

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

    @GetMapping
    public List<Payment> findAll() {
        return paymentService.findAll();
    }

    @PostMapping
    public Payment insert(@RequestBody Payment payment) {
        payment=paymentService.insert(payment);
        return payment;
    }
    @DeleteMapping
    public void deletePayment(@RequestBody Long id){
        paymentService.delete(id);
    }


}

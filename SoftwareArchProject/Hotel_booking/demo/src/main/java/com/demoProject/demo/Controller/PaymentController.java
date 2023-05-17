package com.demoProject.demo.Controller;


import com.demoProject.demo.Classes.PaymentDetails;
import com.demoProject.demo.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payments")
public class PaymentController {

    public final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentDetails payment(@RequestBody PaymentDetails paymentDetails){
        System.out.println(paymentDetails);
        return this.paymentService.makePayment(paymentDetails);
    }
}

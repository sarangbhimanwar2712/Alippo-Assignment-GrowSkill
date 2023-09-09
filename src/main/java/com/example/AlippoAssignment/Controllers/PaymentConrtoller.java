package com.example.AlippoAssignment.Controllers;

import com.example.AlippoAssignment.Models.Payment;
import com.example.AlippoAssignment.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentConrtoller {
    @Autowired
    PaymentService paymentService ;

    @PostMapping("/payment")
    public String makePayment(@RequestBody Payment payment , @RequestParam("userId") int userId,
                              @RequestParam("courseId") int courseId){
        return paymentService.addPayment(payment,userId,courseId) ;
    }
}

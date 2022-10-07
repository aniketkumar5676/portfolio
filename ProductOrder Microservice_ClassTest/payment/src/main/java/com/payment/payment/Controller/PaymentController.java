package com.payment.payment.Controller;

import com.payment.payment.ExceptionHandler.NotFound;
import com.payment.payment.dto.Payment;
import com.payment.payment.Service.PaymentService;
import com.payment.payment.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/paymentDone")
    public Response paymentDone(@RequestBody Payment payment) throws NotFound {
    return  paymentService.paymentDone(payment);
    }


}

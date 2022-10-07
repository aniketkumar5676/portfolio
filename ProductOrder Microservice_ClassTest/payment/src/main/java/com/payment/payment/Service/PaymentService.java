package com.payment.payment.Service;

import com.payment.payment.ExceptionHandler.NotFound;
import com.payment.payment.dto.Payment;
import com.payment.payment.Repo.UserCredRepo;
import com.payment.payment.dto.Response;
import com.payment.payment.dto.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    UserCredRepo userCredRepo;
    @Autowired
    Response response;

    public Response paymentDone(Payment payment) throws NotFound {


        UserCredentials user = userCredRepo.findByUserid(payment.getUserId());
        if (user.getBalance() > payment.getPrice()) {
            UserCredentials newuser = UserCredentials.build(user.getSno(), user.getUserid(), user.getBalance() - payment.getPrice());
            userCredRepo.save(newuser);

            response.setMessage("Success");
            response.setPrice(payment.getPrice());
            response.setProductname(payment.getProductname());
            return response;

        } else {
            response.setMessage("Not Enough Money!! Failed");
            response.setPrice(payment.getPrice());
            response.setProductname(payment.getProductname());
            return response;

        }


    }
}

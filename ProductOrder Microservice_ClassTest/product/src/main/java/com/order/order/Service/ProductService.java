package com.order.order.Service;

import com.order.order.Entity.Products;
import com.order.order.ExceptionHandler.NotFound;
import com.order.order.Repo.ProductRepo;
import com.order.order.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    Payment payment;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductRepo productRepo;

    public TransactionResponse orderProduct(TransactionRequest transactionRequest) throws NotFound {
        Products p;

        try {
            p = productRepo.findById(transactionRequest.getProductid()).get();
        }catch (Exception e)
        {
            throw new NotFound("No product found");

        }
        if(p.getName().equals(transactionRequest.getProductname())) {

              payment.setPrice(p.getPrice());
              payment.setProductname(transactionRequest.getProductname());
              payment.setUserId(transactionRequest.getUserId());


              TransactionResponse paymentResponse = restTemplate.postForObject("http://localhost:8082/payment/paymentDone",
                      payment,
                      TransactionResponse.class);

              return paymentResponse;
          }else{
              throw new NotFound("No combination found of selected product and id");
          }

    }

}

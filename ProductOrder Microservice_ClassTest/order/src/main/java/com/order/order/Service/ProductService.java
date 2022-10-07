package com.order.order.Service;

import com.order.order.Entity.Products;
import com.order.order.ExceptionHandler.NotFound;
import com.order.order.Repo.ProductRepo;
import com.order.order.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    @Autowired
    Payment payment;
    @Autowired
    TransactionResponse transactionResponse;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductRepo productRepo;

    public TransactionResponse orderProduct(TransactionRequest transactionRequest) throws NotFound {


           Products p = productRepo.findByName(transactionRequest.getProductname());

           if(p ==null)
           {
               throw new NotFound("This product not found");

           }else {

               payment.setPrice(p.getPrice());
               payment.setProductname(transactionRequest.getProductname());
               payment.setUserId(transactionRequest.getUserId());


               TransactionResponse paymentResponse = restTemplate.postForObject("http://localhost:8082/payment/paymentDone",
                       payment,
                       TransactionResponse.class);

               return paymentResponse;
           }
    }

}

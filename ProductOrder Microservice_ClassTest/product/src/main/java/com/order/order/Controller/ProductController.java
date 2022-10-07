package com.order.order.Controller;

import com.order.order.ExceptionHandler.NotFound;
import com.order.order.Service.ProductService;
import com.order.order.dto.TransactionRequest;
import com.order.order.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService orderService;

    @PostMapping("/placeOrder")
    public TransactionResponse orderProduct(@RequestBody TransactionRequest transactionRequest) throws NotFound {
       return orderService.orderProduct(transactionRequest);
    }

}

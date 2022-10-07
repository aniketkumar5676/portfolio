package com.catalog.catalog.Controller;

import com.catalog.catalog.Services.CatalogService;
import com.catalog.catalog.dto.TransactionRequest;
import com.catalog.catalog.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("order")
public class MainController {

    @Autowired
    CatalogService catalogService;

    @PostMapping("/placeOrder")
    public TransactionResponse selectCatalog(@RequestBody @Valid  TransactionRequest transactionRequest){
       return catalogService.selectCatalog(transactionRequest);
    }

}

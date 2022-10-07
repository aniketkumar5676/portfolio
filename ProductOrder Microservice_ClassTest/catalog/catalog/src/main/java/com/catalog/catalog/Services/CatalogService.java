package com.catalog.catalog.Services;

import com.catalog.catalog.Entity.UserCredentials;
import com.catalog.catalog.Repo.UserCredRepo;
import com.catalog.catalog.dto.TransactionRequest;
import com.catalog.catalog.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatalogService {

    @Autowired
    UserCredRepo vendorRepo;

    @Autowired
    RestTemplate restTemplate;

    public TransactionResponse selectCatalog(TransactionRequest transactionRequest) {

        TransactionResponse response = restTemplate.postForObject("http://localhost:8081/product/placeOrder",
                transactionRequest,
                TransactionResponse.class);

        return response;

    }
}

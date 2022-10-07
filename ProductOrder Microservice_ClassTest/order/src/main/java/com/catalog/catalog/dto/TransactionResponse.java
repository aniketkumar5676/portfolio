package com.catalog.catalog.dto;

import lombok.Data;

@Data
public class TransactionResponse {
    String productname;
    double price;
    String message;
}

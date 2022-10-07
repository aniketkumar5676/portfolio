package com.catalog.catalog.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TransactionRequest {

    @NotBlank
    private String userId;
    @NotBlank
    private String productname;
    @NotNull
    int productid;
 }

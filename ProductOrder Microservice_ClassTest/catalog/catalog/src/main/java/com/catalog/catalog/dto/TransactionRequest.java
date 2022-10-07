package com.catalog.catalog.dto;

import com.catalog.catalog.Entity.UserCredentials;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TransactionRequest {

    @NotBlank
    private String userId;
    @NotBlank
    private String productname;
 }

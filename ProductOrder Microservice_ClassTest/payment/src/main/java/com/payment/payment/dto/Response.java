package com.payment.payment.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Response {

    String productname;
    double price;
    String message;
}

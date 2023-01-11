package com.luv2code.ecommerce.dto;

import lombok.Data;

@Data
public class PaymentInfo {

    private String receiptEmail;
    private int amount;
    private String currency;
}

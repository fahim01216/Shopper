package com.shopper.ecommerce.dao;

import lombok.Data;


@Data
public class PaymentInfo {
    private int amount;
    private String currency;
    private String receiptEmail;
}

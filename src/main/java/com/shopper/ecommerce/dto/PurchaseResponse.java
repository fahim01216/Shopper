package com.shopper.ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {

    // using this class to send back a java object as JSON
    // Data annotation will generate constructor for final fields
    private final String orderTrackingNumber;

//    we can also use this
//    NonNull annotation
//    private String orderTrackingNumber;
}

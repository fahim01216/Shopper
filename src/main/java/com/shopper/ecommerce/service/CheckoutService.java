package com.shopper.ecommerce.service;

import com.shopper.ecommerce.dao.PaymentInfo;
import com.shopper.ecommerce.dto.Purchase;
import com.shopper.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}

package com.finalproject.ecommerce.service;

import com.finalproject.ecommerce.dto.Purchase;
import com.finalproject.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}

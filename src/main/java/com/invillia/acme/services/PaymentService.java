package com.invillia.acme.services;

import com.invillia.acme.entities.Payment;

public interface PaymentService {
    
    Payment generatePayment(Payment payment, Long orderId);
}

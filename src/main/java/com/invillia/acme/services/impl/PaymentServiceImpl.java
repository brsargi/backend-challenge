package com.invillia.acme.services.impl;

import com.invillia.acme.entities.Order;
import com.invillia.acme.entities.Payment;
import com.invillia.acme.entities.enums.OrderStatus;
import com.invillia.acme.repositories.PaymentRepository;
import com.invillia.acme.services.OrderService;
import com.invillia.acme.services.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    private OrderService orderService;
    private PaymentRepository paymentRepository;

    public PaymentServiceImpl(OrderService orderService, PaymentRepository paymentRepository) {
        this.orderService = orderService;
        this.paymentRepository = paymentRepository;
    }
    
    @Override
    public Payment generatePayment(Payment payment, Long orderId) {
        
        Order order = this.orderService.findById(orderId);
        order.setStatus(OrderStatus.COMPLETE);
        
        payment.setOrder(order);
  
        return this.paymentRepository.save(payment);
    }
}

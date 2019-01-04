package com.invillia.acme.mappers;

import com.invillia.acme.dtos.PaymentDto;
import com.invillia.acme.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    
    public PaymentDto mapToPaymentDto(Payment payment){
        
        return PaymentDto.builder()
                .id(payment.getId())
                .creditCardNumber(payment.getCreditCardNumber())
                .paymentDate(payment.getPaymentDate())
                .status(payment.getStatus().toString()).build();
    }
    
    public Payment mapToPayment(PaymentDto paymentDto){
        
        return Payment.builder()
                .id(paymentDto.getId())
                .creditCardNumber(paymentDto.getCreditCardNumber()).build();
    }
}

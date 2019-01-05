package com.invillia.acme.rest.v1;

import com.invillia.acme.dtos.PaymentDto;
import com.invillia.acme.entities.Payment;
import com.invillia.acme.mappers.PaymentMapper;
import com.invillia.acme.services.PaymentService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders/{orderId}/payments")
public class PaymentResource {
    
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    public PaymentResource(PaymentService paymentService, PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }
    
    @PostMapping
    public ResponseEntity generatePayment(@RequestBody @Valid PaymentDto paymentDto, @PathVariable Long orderId){
        
        Payment payment = this.paymentService.generatePayment(paymentMapper.mapToPayment(paymentDto), orderId);
        
        return new ResponseEntity(paymentMapper.mapToPaymentDto(payment), HttpStatus.CREATED);
    }
}

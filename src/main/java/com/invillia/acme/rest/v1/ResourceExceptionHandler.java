package com.invillia.acme.rest.v1;

import com.invillia.acme.dtos.ErrorResponse;
import com.invillia.acme.exceptions.OrderCanNotBeRefund;
import com.invillia.acme.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ResourceExceptionHandler {
    
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity resourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        log.warn(resourceNotFoundException.getMessage());
        return new ResponseEntity(new ErrorResponse(resourceNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value = OrderCanNotBeRefund.class)
    public ResponseEntity orderCanNotBeRefund(OrderCanNotBeRefund orderCanNotBeRefund){
        log.warn(orderCanNotBeRefund.getMessage());
        
        return new ResponseEntity(new ErrorResponse(orderCanNotBeRefund.getMessage()), HttpStatus.BAD_REQUEST);
    }
}

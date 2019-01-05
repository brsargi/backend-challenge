package com.invillia.acme.exceptions;

public class OrderItemCanNotBeRefundException extends RuntimeException{
    
    public OrderItemCanNotBeRefundException(String message){
        super(message);
    }
}

package com.invillia.acme.exceptions;

public class OrderCanNotBeRefundException extends RuntimeException{
    
    public OrderCanNotBeRefundException(String message){
        super(message);
    }
}

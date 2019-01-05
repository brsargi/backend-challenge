package com.invillia.acme.exceptions;

public class OrderCanNotBeRefund extends RuntimeException{
    
    public OrderCanNotBeRefund(String message){
        super(message);
    }
}

package com.invillia.acme.exceptions;

public class ResourceNotFoundException extends RuntimeException{
 
    public ResourceNotFoundException(String message){
        super(message);
    }
}

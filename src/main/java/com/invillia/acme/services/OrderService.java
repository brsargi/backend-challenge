package com.invillia.acme.services;

import com.invillia.acme.entities.Order;
import java.util.Collection;

public interface OrderService {
    
    Order save(Order order);
    
    Order findById(Long id);
        
    Collection<Order> find(String address, String status);
    
    void refundOrderById(Long id);
}

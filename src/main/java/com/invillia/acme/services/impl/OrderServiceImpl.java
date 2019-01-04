package com.invillia.acme.services.impl;

import com.invillia.acme.entities.Order;
import com.invillia.acme.exceptions.ResourceNotFoundException;
import com.invillia.acme.repositories.OrderRepository;
import com.invillia.acme.services.OrderService;
import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    @Override
    public Order save(Order order) {
        
        return this.orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        
        Optional<Order> order = this.orderRepository.findById(id);
        
        if(order.isPresent()){
            
            return order.get();
        }
        
        throw new ResourceNotFoundException("Order with id " + id + " not found");
    }

    @Override
    public Collection<Order> find(String address, String status) {
        
        return this.orderRepository.findByParameters(address, status);
    }
    
}

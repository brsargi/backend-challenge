package com.invillia.acme.services.impl;

import com.invillia.acme.entities.Order;
import com.invillia.acme.entities.OrderItem;
import com.invillia.acme.exceptions.ResourceNotFoundException;
import com.invillia.acme.repositories.OrderItemRepository;
import com.invillia.acme.services.OrderItemService;
import com.invillia.acme.services.OrderService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderService orderService;
    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderService orderService, OrderItemRepository orderItemRepository) {
        this.orderService = orderService;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void refundById(Long orderId, Long orderItemId) {
       
        Order order = this.orderService.findById(orderId);
                
        Optional<OrderItem> orderItem = order.getItens().stream().filter((item) -> item.getId().equals(orderItemId)).findFirst();
        
        if(orderItem.isPresent()){
                    
            if(orderItem.get().isCanBeRefund(order.getStatus())){
                               
                order.getItens().remove(orderItem.get());                
                                
                this.orderService.save(order);
                this.orderItemRepository.deleteById(orderItemId);
            }           
        }else{
          throw new ResourceNotFoundException("The order item with id " + orderItemId + " not found.");  
        }
    }
}

package com.invillia.acme.mappers;

import com.invillia.acme.dtos.OrderDto;
import com.invillia.acme.dtos.OrderItemDto;
import com.invillia.acme.entities.Order;
import com.invillia.acme.entities.OrderItem;
import com.invillia.acme.entities.enums.OrderStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    
    public OrderDto mapToOrderDto(Order order){
        
        OrderDto orderDto = OrderDto.builder()
                .id(order.getId())
                .address(order.getAddress())
                .confirmationDate(order.getConfirmationDate())
                .status(order.getStatus().toString())
                .itens(mapToOrderItensDto(order.getItens())).build();
                
        return orderDto;
    }
    
    public Order mapToOrder(OrderDto orderDto){
        
        Order order = Order.builder()
                        .id(orderDto.getId())
                        .address(orderDto.getAddress())
                        .itens(mapToOrderItens(orderDto.getItens()))
                        .build();
        
        return order;   
    }
    
    public Collection<OrderDto> mapToOrdersDto(Collection<Order> orders){
        
        List<OrderDto> ordersDto = new ArrayList<>();
    
        orders.forEach((order) -> ordersDto.add(mapToOrderDto(order)));
        
        return ordersDto;
    }
    
    public OrderItemDto mapToOrderItemDto(OrderItem orderItem){
        
        return OrderItemDto.builder()
                .id(orderItem.getId())
                .description(orderItem.getDescription())
                .price(orderItem.getPrice())
                .quantity(orderItem.getQuantity()).build();
    }
    
    public OrderItem mapToOrderItem(OrderItemDto orderItemDto){
        
        return OrderItem.builder()
                .id(orderItemDto.getId())
                .description(orderItemDto.getDescription())
                .price(orderItemDto.getPrice())
                .quantity(orderItemDto.getQuantity()).build();
    }
    
    public Set<OrderItemDto> mapToOrderItensDto(Set<OrderItem> orderItens){
        
        Set<OrderItemDto> orderItensDto = new HashSet<>();
        
        orderItens.forEach((orderItem) -> orderItensDto.add(mapToOrderItemDto(orderItem)));
        
        return orderItensDto;
    }
    
    public Set<OrderItem> mapToOrderItens(Set<OrderItemDto> orderItensDto){
        
        Set<OrderItem> orderItens = new HashSet<>();
        
        orderItensDto.forEach((orderItemDto) -> orderItens.add(mapToOrderItem(orderItemDto)));
        
        return orderItens;
    }
}

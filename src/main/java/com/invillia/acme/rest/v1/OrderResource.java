package com.invillia.acme.rest.v1;

import com.invillia.acme.dtos.OrderDto;
import com.invillia.acme.entities.Order;
import com.invillia.acme.mappers.OrderMapper;
import com.invillia.acme.services.OrderService;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderResource {
    
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderResource(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }
    
    @PostMapping
    public ResponseEntity insert(@RequestBody @Valid OrderDto orderDto){
        
        Order order = this.orderService.save(orderMapper.mapToOrder(orderDto));
        
        return new ResponseEntity(orderMapper.mapToOrderDto(order), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        
        Order order = this.orderService.findById(id);
        
        return new ResponseEntity(orderMapper.mapToOrderDto(order), HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity findByParamenters(@RequestParam(required = false) String address, 
                                            @RequestParam(required = false) String status){
        
        Collection<Order> orders = this.orderService.find(address, status);
        
        return new ResponseEntity(orderMapper.mapToOrdersDto(orders), HttpStatus.OK);
    }
    
    @PatchMapping("/{id}/refunded")
    public void refundOrderById(@PathVariable Long id){
        
        this.orderService.refundOrderById(id);
    }
}

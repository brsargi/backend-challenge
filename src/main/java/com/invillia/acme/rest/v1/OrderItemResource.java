package com.invillia.acme.rest.v1;

import com.invillia.acme.services.OrderItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders/{orderId}/itens/{orderItemId}")
public class OrderItemResource {
    
    private final OrderItemService orderItemService;

    public OrderItemResource(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }
    
    @DeleteMapping("/refunded")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void refundById(@PathVariable Long orderId, @PathVariable Long orderItemId){
        
        this.orderItemService.refundById(orderId, orderItemId);
    }
}

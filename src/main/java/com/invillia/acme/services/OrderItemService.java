package com.invillia.acme.services;

public interface OrderItemService {

    void refundById(Long orderId, Long orderItemId);
}

package com.invillia.acme.services;

import com.invillia.acme.entities.Order;
import com.invillia.acme.entities.OrderItem;
import com.invillia.acme.repositories.OrderRepository;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OrderServiceTest {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderService orderService;
    
    @Before
    public void setUp(){
        
        Order order = Order.builder()
                        .address("AddressOrder1").build();
        
        OrderItem item1 = OrderItem.builder()
                            .description("Item1")
                            .quantity(2)
                            .price(new BigDecimal("123.23")).build();
        
        Set<OrderItem> itens = new HashSet<>();
        itens.add(item1);
        
        order.setItens(itens);
        
        this.orderRepository.save(order);
    }
    
    @After
    public void tearDown(){
        
        this.orderRepository.deleteAll();
    }
    
    @Test
    public void testFindAll(){
        
        Collection<Order> orders = this.orderService.find(null, null);
        
        Assert.assertEquals(1, orders.size());
    }
    
    @Test
    public void testFindByParameters(){
        
        Collection<Order> orders = this.orderService.find("AddressOrder1", null);
        
        Assert.assertEquals(1, orders.size());
    }
}

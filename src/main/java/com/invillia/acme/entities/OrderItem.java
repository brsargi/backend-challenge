package com.invillia.acme.entities;

import com.invillia.acme.entities.enums.OrderStatus;
import com.invillia.acme.exceptions.OrderItemCanNotBeRefundException;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orders_itens")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString(includeFieldNames = true)
@EqualsAndHashCode
public class OrderItem implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;
    
    private BigDecimal price;
    
    private Integer quantity;   
    
    public boolean isCanBeRefund(OrderStatus orderStatus){
        
        if(OrderStatus.WAITING_PAYMENT.equals(orderStatus)){
            return true;
        }
        
        throw new OrderItemCanNotBeRefundException("The order item with id " + id + " can't be refund.");
    }
    
}

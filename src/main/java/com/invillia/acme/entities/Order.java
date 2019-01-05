package com.invillia.acme.entities;

import com.invillia.acme.entities.enums.OrderStatus;
import com.invillia.acme.entities.enums.PaymentStatus;
import com.invillia.acme.exceptions.OrderCanNotBeRefundException;
import com.invillia.acme.exceptions.OrderItemCanNotBeRefundException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString(includeFieldNames = true)
@EqualsAndHashCode
public class Order implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String address;
    
    private LocalDateTime confirmationDate;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Set<OrderItem> itens;
    
    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
    private Payment payment;
    
    @PrePersist
    private void prePersist(){
        
        this.confirmationDate = LocalDateTime.now();
        this.status = OrderStatus.WAITING_PAYMENT;
    }
    
    public boolean isCanBeRefund(){
        
        if(payment != null && payment.isUntilTenDaysConfirmationPayment()){
            
            return true;
        }
        
        throw new OrderCanNotBeRefundException("The order with id " + id + " can't be refund.");
    }
    
    public void refund(){
        
        if(isCanBeRefund()){
      
            this.status = OrderStatus.REFUNDED;
            this.payment.setStatus(PaymentStatus.REFUNDED);
        }
    }
}

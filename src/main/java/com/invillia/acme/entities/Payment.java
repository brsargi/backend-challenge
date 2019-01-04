package com.invillia.acme.entities;

import com.invillia.acme.entities.enums.PaymentStatus;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString(includeFieldNames = true)
@EqualsAndHashCode
public class Payment implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    
    private String creditCardNumber;
    
    private LocalDateTime paymentDate;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;
    
    @PrePersist
    private void prePersist(){
        this.status = PaymentStatus.COMPLETE;
        this.paymentDate = LocalDateTime.now();
    }
}

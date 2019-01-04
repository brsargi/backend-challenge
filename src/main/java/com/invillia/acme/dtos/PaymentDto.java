package com.invillia.acme.dtos;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class PaymentDto {
    
    private Long id;
    
    private String status;
    
    private String creditCardNumber;
    
    private LocalDateTime paymentDate;
}

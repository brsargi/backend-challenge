package com.invillia.acme.dtos;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
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
    
    @NotEmpty(message = "The credit card number can't be empty.")
    private String creditCardNumber;
    
    private LocalDateTime paymentDate;
}

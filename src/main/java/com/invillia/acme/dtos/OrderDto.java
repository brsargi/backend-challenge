package com.invillia.acme.dtos;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import javax.validation.Valid;
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
public class OrderDto {
    
    private Long id;
    
    @NotEmpty(message = "The address order can't be empty.")
    private String address;
    
    private LocalDateTime confirmationDate;
    
    private String status;
    
    @Valid
    private Set<OrderItemDto> itens;
}

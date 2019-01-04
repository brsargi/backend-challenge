package com.invillia.acme.dtos;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
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
    
    private String address;
    
    private LocalDateTime confirmationDate;
    
    private String status;
    
    private Set<OrderItemDto> itens;
}

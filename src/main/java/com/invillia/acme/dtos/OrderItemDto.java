package com.invillia.acme.dtos;

import java.math.BigDecimal;
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
public class OrderItemDto {
    
    private Long id;
    
    private String description;
    
    private BigDecimal price;
    
    private Integer quantity;
}

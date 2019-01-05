package com.invillia.acme.dtos;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    
    @NotEmpty(message = "The description can't be empty.")
    private String description;
    
    @DecimalMin(value = "0.1", inclusive = true, message = "The price can't be null.")
    private BigDecimal price;
    
    @Min(value = 1 ,message = "The quantity have be greater than 0.")
    private Integer quantity;
}

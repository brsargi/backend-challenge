package com.invillia.acme.dtos;

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
public class StoreDto {

    private Long id;
    
    @NotEmpty(message = "The store name can't be empty.")
    private String name;
    
    @NotEmpty(message = "The address store can't be empty.")
    private String address;
}

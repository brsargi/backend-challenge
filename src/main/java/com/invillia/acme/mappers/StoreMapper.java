package com.invillia.acme.mappers;

import com.invillia.acme.dtos.StoreDto;
import com.invillia.acme.entities.Store;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {
    
    public StoreDto mapToStoreDto(Store store){
                
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .createdAt(store.getCreatedAt())
                .updatedAt(store.getUpdatedAt()).build();
    }
    
    public Store mapToStore(StoreDto storeDto){
        
        return Store.builder()
                .id(storeDto.getId())
                .name(storeDto.getName())
                .address(storeDto.getAddress())
                .createdAt(storeDto.getCreatedAt())
                .updatedAt(storeDto.getUpdatedAt()).build();
    }
    
    public Collection<StoreDto> mapToStoresDto(Collection<Store> stores){
        
        List<StoreDto> storesDto = new ArrayList<>();
        
        stores.forEach((store) -> storesDto.add(mapToStoreDto(store)));
        
        return storesDto;
    }
}

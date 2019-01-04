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
                .address(store.getAddress()).build();
    }
    
    public Store mapToStore(StoreDto storeDto){
        
        return Store.builder()
                .id(storeDto.getId())
                .name(storeDto.getName())
                .address(storeDto.getAddress()).build();
    }
    
    public Collection<StoreDto> mapToStoresDto(Collection<Store> stores){
        
        List<StoreDto> storesDto = new ArrayList<>();
        
        stores.forEach((store) -> storesDto.add(mapToStoreDto(store)));
        
        return storesDto;
    }
}

package com.invillia.acme.rest.v1;

import com.invillia.acme.dtos.StoreDto;
import com.invillia.acme.entities.Store;
import com.invillia.acme.mappers.StoreMapper;
import com.invillia.acme.services.StoreService;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreResource {
    
    private StoreService storeService;
    private StoreMapper storeMapper;

    public StoreResource(StoreService storeService, StoreMapper storeMapper) {
        this.storeService = storeService;
        this.storeMapper = storeMapper;
    }
    
    @PostMapping
    public ResponseEntity insert(@RequestBody @Valid StoreDto storeDto){
        
        Store store = this.storeService.save(storeMapper.mapToStore(storeDto));
        
        return new ResponseEntity(storeMapper.mapToStoreDto(store), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody @Valid StoreDto storeDto, @PathVariable Long id){
               
        this.storeService.update(storeMapper.mapToStore(storeDto), id);
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        
        this.storeService.deleteById(id);
    }
    
    @GetMapping
    public ResponseEntity find(@RequestParam(required = false) String name, @RequestParam(required = false) String address){
            	
        Collection<StoreDto> storesDto = storeMapper.mapToStoresDto(this.storeService.find(name, address));
    
        return new ResponseEntity(storesDto, HttpStatus.OK);
    }
}

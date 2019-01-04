package com.invillia.acme.services.impl;

import com.invillia.acme.entities.Store;
import com.invillia.acme.exceptions.ResourceNotFoundException;
import com.invillia.acme.repositories.StoreRepository;
import com.invillia.acme.services.StoreService;
import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService{

    private StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
    
    @Override
    public Store save(Store store) {
        return this.storeRepository.save(store);
    }

    @Override
    public Store findById(Long id) {
        
        Optional<Store> store = this.storeRepository.findById(id);
        
        if(store.isPresent()){
            return store.get();
        }
        
        throw new ResourceNotFoundException("Store with id " + id + " not found");
    }

    @Override
    public void deleteById(Long id) {
        
        findById(id);
        
        this.storeRepository.deleteById(id);
    }
    
    @Override
    public void update(Store store, Long id) {
    
        findById(id);
        
        save(store);
    }

    @Override
    public Collection<Store> find(String name, String address) {
    	    	
        return this.storeRepository.findByParameters(name, address);
    }
}

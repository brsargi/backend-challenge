package com.invillia.acme.services;

import com.invillia.acme.entities.Store;
import java.util.Collection;

public interface StoreService {
    
    Store save(Store store);
    
    void update(Store store, Long id);

    Store findById(Long id);
    
    void deleteById(Long id);
    
    Collection<Store> find(String name, String address);
}

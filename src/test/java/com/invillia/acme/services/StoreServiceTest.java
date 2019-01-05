package com.invillia.acme.services;

import com.invillia.acme.entities.Store;
import com.invillia.acme.repositories.StoreRepository;
import java.util.Collection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class StoreServiceTest {
    
    @Autowired
    private StoreRepository storeRepository;
    
    @Autowired
    private StoreService storeService;
    
    @Before
    public void setUp(){
        
        Store store1 = Store.builder()
                        .name("Store1")
                        .address("Address1").build();
        
        Store store2 = Store.builder()
                        .name("Store2")
                        .address("Address2").build();
        
        this.storeRepository.save(store1);
        this.storeRepository.save(store2);
        
    }
    
    @After
    public void tearDown(){
        this.storeRepository.deleteAll();
    }
    
    @Test
    public void testSave(){
        
        Store store1 = Store.builder()
                        .name("Store11")
                        .address("Address11").build();
        
        this.storeService.save(store1);
        
        Assert.assertNotNull(store1.getId());
    }
    
    @Test
    public void testFindAll(){
        
        Collection<Store> stores = this.storeService.find(null, null);
                
        Assert.assertEquals(2, stores.size());
    }
    
    @Test
    public void testFindByParameters(){
        
        Collection<Store> stores = this.storeService.find(null, "Address1");
        
        Assert.assertEquals(1, stores.size());
    }
}

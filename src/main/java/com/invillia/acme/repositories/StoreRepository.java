package com.invillia.acme.repositories;

import com.invillia.acme.entities.Store;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreRepository extends JpaRepository<Store, Long>, JpaSpecificationExecutor<Store> {
 
    default List<Store> findByParameters(String name, String address) {
        return findAll(Specification.where(nameLike(name))
            .and(addressLike(address)));
    }

  static Specification<Store> nameLike(String name) {
      
    return (name == null || name.isEmpty()) ? null : (Specification<Store>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"),
        ("%"+name+"%"));
  }

  static Specification<Store> addressLike(String address) {
    return (address == null || address.isEmpty()) ? null : (Specification<Store>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("address"),
        ("%"+address+"%"));
  }
}

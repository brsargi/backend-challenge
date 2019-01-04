package com.invillia.acme.repositories;

import com.invillia.acme.entities.Order;
import com.invillia.acme.entities.enums.OrderStatus;
import java.util.Collection;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>{
    
    default Collection<Order> findByParameters(String address, String status) {
        return findAll(Specification.where(addressLike(address))
            .and(statusIsEqual(status)));
    }
    
    static Specification<Order> addressLike(String address) {
        return (address == null || address.isEmpty()) ? null : (Specification<Order>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("address"),
            ("%"+address+"%"));
    }
    
    static Specification<Order> statusIsEqual(String status) {
        return (status == null || status.isEmpty()) ? null : (Specification<Order>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"),
            OrderStatus.valueOf(status.toUpperCase()));
    }
}

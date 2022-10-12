package com.ecommerce.mvc.repositories;

import com.ecommerce.mvc.models.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder,Integer> {
}

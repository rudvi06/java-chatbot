package com.ecommerce.mvc.repositories;
import com.ecommerce.mvc.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByName(String name);

    Customer findByEmailId(String emailId);
}

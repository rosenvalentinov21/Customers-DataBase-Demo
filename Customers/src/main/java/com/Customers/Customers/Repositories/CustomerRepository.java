package com.Customers.Customers.Repositories;

import com.Customers.Customers.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer , Long> {

    Optional<Customer> findCustomerByFirstNameAndLastName(String firstName , String lastName);

}

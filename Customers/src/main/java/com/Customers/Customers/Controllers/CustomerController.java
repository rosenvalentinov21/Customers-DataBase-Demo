package com.Customers.Customers.Controllers;

import com.Customers.Customers.Entities.Customer;
import com.Customers.Customers.Repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepository CustomerRepo;

    CustomerController(CustomerRepository CustomerRepo)
    {
        this.CustomerRepo = CustomerRepo;
    }

    @GetMapping("/fetch")
    public List<Customer> GetAllCustomers()
    {
        return CustomerRepo.findAll();
    }

    @GetMapping("/find")
    public ResponseEntity<?> findCustomer(String firstName , String lastName)
    {
        Optional<Customer> customer = CustomerRepo.findCustomerByFirstNameAndLastName(firstName , lastName);
        if(customer.isEmpty())
        {
            return ResponseEntity.ok("No customer found!");
        }
        return ResponseEntity.ok(customer.get());
    }

}

package com.restaurant.controller;

import com.restaurant.controller.exceptions.CustomerNotFoundException;
import com.restaurant.model.entity.Customer;
import com.restaurant.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerController
{
    @Autowired
    private final CustomerRepository repository;
    @Autowired
    public CustomerController(CustomerRepository repository)
    {
        this.repository = repository;
    }
    @GetMapping("/customers")
    List<Customer> retrieveAllCustomers()
    {
        return repository.findAll();
    }
    @GetMapping("/customers/{phone_number}")
    Customer retrieveCustomer(@PathVariable("phone_number") String phone_number)
    {
        return repository.findById(phone_number)
                .orElseThrow(() -> new CustomerNotFoundException(phone_number));
    }

    @PostMapping("/customers")
    Customer createCustomer(@RequestBody Customer newCustomer)
    {
        return repository.save(newCustomer);
    }

    @PutMapping("/customers/{phone_number}")
    Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable("phone_number") String phone_number)
    {
        return repository.findById(phone_number)
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setEmail(newCustomer.getEmail());
                    return repository.save(customer);
                })
                .orElseGet(() ->{
                    newCustomer.setNumber(phone_number);
                    return repository.save(newCustomer);
                });


    }
    @DeleteMapping("/customers/{phone_number}")
    void deleteServer(@PathVariable("phone_number") String phone_number)
    {
        repository.deleteById(phone_number);
    }
}

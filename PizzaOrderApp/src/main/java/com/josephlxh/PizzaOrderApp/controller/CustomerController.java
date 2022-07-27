package com.josephlxh.PizzaOrderApp.controller;
/* Created by limxuanhui on 30/6/22 */

import com.josephlxh.PizzaOrderApp.dto.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    // customerRepository

    @GetMapping("/{customerId}")
    Customer getCustomerById(@PathVariable("customerId") Integer customerId) {
        return null;
    }

    @PostMapping("/")
    Customer createCustomer(@RequestBody Customer customer) {
        // customerRepository.save(customer);
        return null;
    }

    @PutMapping("/")
    Customer editCustomer(@RequestBody Customer customer) {
        return null;
    }

    @DeleteMapping("/{customerId}")
    Customer deleteCustomer(@PathVariable("customerId") Integer customerId) {
        return null;
    }
}

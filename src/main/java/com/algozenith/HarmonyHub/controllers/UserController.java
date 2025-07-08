package com.algozenith.HarmonyHub.controllers;

import com.algozenith.HarmonyHub.exceptions.CustomerNotFoundException;
import com.algozenith.HarmonyHub.models.Customer;
import com.algozenith.HarmonyHub.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    UserController(@Qualifier("selfUserService") UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) throws CustomerNotFoundException {
        Customer customer = userService.getCustomerById(id);
        ResponseEntity<Customer> responseEntity;
        responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping()
    public List<Customer> getAllCustomer() {
        return userService.getAllCustomers();
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) throws CustomerNotFoundException {
        return userService.updateCustomer(id, customer);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) { // can use DTO as well.
        return userService.createCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) throws CustomerNotFoundException {
        userService.deleteCustomer(id);
    }
}

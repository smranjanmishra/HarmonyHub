package com.algozenith.HarmonyHub.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

package com.algozenith.HarmonyHub.services;

import com.algozenith.HarmonyHub.exceptions.CustomerNotFoundException;
import com.algozenith.HarmonyHub.models.Customer;

import java.util.List;

public interface UserService {
    Customer getCustomerById(Long Id) throws CustomerNotFoundException;
    List<Customer> getAllCustomers();
    Customer updateCustomer(Long id, Customer customer) throws CustomerNotFoundException;
    Customer createCustomer(Customer customer);
    void deleteCustomer(Long id) throws CustomerNotFoundException;
}

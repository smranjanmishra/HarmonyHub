package com.algozenith.HarmonyHub.services;

import com.algozenith.HarmonyHub.exceptions.CustomerNotFoundException;
import com.algozenith.HarmonyHub.models.Customer;
import com.algozenith.HarmonyHub.repositories.CustomerRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfUserService")
@Primary
public class SelfUserService implements UserService {
    private CustomerRepository customerRepository;

    SelfUserService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }
    @Override
    public Customer getCustomerById(Long Id) throws CustomerNotFoundException {
        Optional<Customer> optionalUser = customerRepository.findById(Id);

        if (optionalUser.isEmpty()) {
            throw new CustomerNotFoundException(Id, "Customer not found");
        }

        return optionalUser.get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> allUser = customerRepository.findAll();
        return allUser;
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) throws CustomerNotFoundException {
        // Retrieve the existing user from the database
        Optional<Customer> existingProductOptional = customerRepository.findById(id);

        // Check if the User exists in the database
        if (existingProductOptional.isPresent()) {
            Customer existingProduct = existingProductOptional.get();

            // Update the attributes of the existing Customer with the values from the provided customer
            existingProduct.setName(customer.getName());
            existingProduct.setContact_Number(customer.getContact_Number());
//            existingProduct.setPurchaseHistory(customer.getPurchaseHistory());
            // Update other attributes as needed

            // Save the updated Customer back to the database
            return customerRepository.save(existingProduct);
        } else {
            // Handle the case where the User  with the given ID does not exist
            // You might throw an exception or return null, depending on your requirements
            throw new CustomerNotFoundException(id, "User not found, check if the User exits");
        }
    }

    @Override
    public Customer createCustomer( Customer customer) {
        Customer customer1=customerRepository.save(customer);
        return customer1;
    }

    @Override
    public void deleteCustomer(Long id) throws CustomerNotFoundException {
        Optional<Customer> optionalProduct = customerRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Customer customer = optionalProduct.get();
            customerRepository.delete(customer);
        } else {
            throw new CustomerNotFoundException(id, "User not found, check if the User exits");
        }
    }
}

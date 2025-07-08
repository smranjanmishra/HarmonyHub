package com.algozenith.HarmonyHub.repositories;

import com.algozenith.HarmonyHub.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    Customer save(Customer customer);
}

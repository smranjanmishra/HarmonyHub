package com.algozenith.HarmonyHub.repositories;

import com.algozenith.HarmonyHub.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Override
    Optional<Transaction> findById(Long id);

    @Override
    List<Transaction> findAll();

    @Override
    Transaction save(Transaction transaction);

    @Override
    void deleteById(Long id);
}

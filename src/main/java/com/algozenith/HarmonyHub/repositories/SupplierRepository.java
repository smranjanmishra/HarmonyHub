package com.algozenith.HarmonyHub.repositories;

import com.algozenith.HarmonyHub.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Override
    Supplier save(Supplier supplier);

    @Override
    Optional<Supplier> findById(Long id);
}

package com.algozenith.HarmonyHub.repositories;

import com.algozenith.HarmonyHub.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    Category save(Category category);

    @Override
    Optional<Category> findById(Long id);
}

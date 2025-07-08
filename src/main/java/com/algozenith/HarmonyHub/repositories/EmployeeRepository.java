package com.algozenith.HarmonyHub.repositories;

import com.algozenith.HarmonyHub.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

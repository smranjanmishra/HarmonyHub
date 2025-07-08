package com.algozenith.HarmonyHub.controllers;

import com.algozenith.HarmonyHub.models.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(@Qualifier("EmployeeService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Employee replaceEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return employeeService.replaceEmployee(id, employee);
    }

    @PatchMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeePatchRequest patchRequest) {
        return employeeService.updateEmployee(id, patchRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }
}

package com.deneme.employeemanager.service;

import com.deneme.employeemanager.exception.userNotFoundException;
import com.deneme.employeemanager.model.Employee;
import com.deneme.employeemanager.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    //public EmployeeService(EmployeeRepo employeeRepo) {
     //   this.employeeRepo = employeeRepo;
    // }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);

    }
    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);

    }
   // public Optional<Employee> findEmployeeById(Long id){
     //   return employeeRepo.findEmployeeById(id);
    //}
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()->new userNotFoundException("user by id" + id + "was not found"));
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}

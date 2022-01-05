package com.challengeoh.EmployeeMicroservice.service;

import com.challengeoh.EmployeeMicroservice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(String documentId);

    public void save(Employee employee);

    public void update(Employee employee, String documentI);

    public void destroy(String documentId);
}

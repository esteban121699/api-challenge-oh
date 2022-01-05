package com.challengeoh.EmployeeMicroservice.dao;

import com.challengeoh.EmployeeMicroservice.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(String documentId);

    public void save(Employee employee);

    public void update(Employee employee, String documentId);

    public void destroy(String documentId);
}

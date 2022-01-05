package com.challengeoh.EmployeeMicroservice.service;

import com.challengeoh.EmployeeMicroservice.dao.EmployeeDAO;
import com.challengeoh.EmployeeMicroservice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        List<Employee> employees= employeeDAO.findAll();
        return employees;
    }

    @Override
    public Employee findById(String documentId) {
        Employee employee = employeeDAO.findById(documentId);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public void update(Employee employee, String documentId) {
        employeeDAO.update(employee, documentId);
    }

    @Override
    public void destroy(String documentId) {
        employeeDAO.destroy(documentId);
    }
}

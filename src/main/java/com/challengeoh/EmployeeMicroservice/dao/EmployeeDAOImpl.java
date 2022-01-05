package com.challengeoh.EmployeeMicroservice.dao;

import com.challengeoh.EmployeeMicroservice.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(String documentId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee employee = currentSession.get(Employee.class, documentId);

        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);

        Transaction txn = currentSession.beginTransaction();

        currentSession.save(employee);

        txn.commit();
    }

    @Override
    public void update(Employee employee, String documentId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Transaction txn = currentSession.beginTransaction();

        Employee employeeModel = currentSession.get(Employee.class, documentId);
        employeeModel.setFirstName(employee.getFirstName());
        employeeModel.setLastName(employee.getLastName());
        employeeModel.setAge(employee.getAge());
        employeeModel.setDateOfBirth(employee.getDateOfBirth());
        employeeModel.setSalary(employee.getSalary());

        currentSession.update(employeeModel);

        txn.commit();
    }

    @Override
    public void destroy(String documentId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Transaction txn = currentSession.beginTransaction();

        Query<Employee> query = currentSession.createQuery("delete from Employee where documentId=:documentId");

        query.setParameter("documentId", documentId);
        query.executeUpdate();
        txn.commit();
    }
}

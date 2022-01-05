package com.challengeoh.EmployeeMicroservice.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.Date;

@Entity
@Table(name="foh_empleados")
public class Employee {

    @Id
    @Column(name = "documento_id")
    @Size(max = 15, message = "Máximo 15 caracteres.")
    private String documentId;

    @Column(name = "nombres")
    @Size(max = 50, message = "Máximo 50 caracteres.")
    private String firstName;

    @Column(name = "apellidos")
    @Size(max = 50, message = "Máximo 50 caracteres.")
    private String lastName;

    @Column(name = "edad")
    @Min(value = 0 ,message = "La edad debe ser mayor a 0.")
    @Max(value = 99 ,message = "La edad debe ser menor a 0.")
    @Digits(integer = 2, fraction = 0, message = "La edad debe ser numérico.")
    private int age;

    @Column(name = "fecha_nacimiento")
    private Date dateOfBirth;

    @Column(name = "salario")
    @Min(value = 0 ,message = "El salario debe ser mayor a 0.")
    @Digits(integer = 6, fraction = 2, message = "La edad debe ser numérico.")
    private double salary;

    public Employee() {}

    public Employee(String documentId, String firstName, String lastName, int age, Date dateOfBirth, double salary) {
        this.documentId = documentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [documentId=" + documentId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", age=" + age + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + "]";
    }
}

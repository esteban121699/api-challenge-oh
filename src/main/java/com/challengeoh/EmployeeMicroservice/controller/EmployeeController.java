package com.challengeoh.EmployeeMicroservice.controller;

import com.challengeoh.EmployeeMicroservice.entity.Employee;
import com.challengeoh.EmployeeMicroservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> index() {
        List<Employee> employees = employeeService.findAll();

        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/employees/{documentId}")
    public ResponseEntity<Employee> show(@PathVariable String documentId) {
        Employee employee = employeeService.findById(documentId);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employees")
    public ResponseEntity store(@Valid @RequestBody Employee employeeBody, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Employee employee = employeeService.findById(employeeBody.getDocumentId());

        if (employee != null) {
            return ResponseEntity.badRequest().body("Ya existe un empleado registrado con este documento");
        }

        employeeService.save(employeeBody);

        return ResponseEntity.ok().body(employeeBody);
    }

    @PutMapping("/employees/{documentId}")
    public ResponseEntity update(@Valid @RequestBody Employee employeeBody, BindingResult result, @PathVariable String documentId) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Employee employee = employeeService.findById(documentId);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        employeeService.update(employeeBody, documentId);

        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("employees/{documentId}")
    public ResponseEntity<Employee> destroy(@PathVariable String documentId) {

        Employee employee = employeeService.findById(documentId);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        employeeService.destroy(documentId);

        return ResponseEntity.ok().body(employee);
    }
}

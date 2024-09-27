package com.project.EMS_Azure.controller;



import com.project.EMS_Azure.model.Employee;
import com.project.EMS_Azure.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    //Add employee REST API
    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee)
    {
        System.out.println("Started controller" + employee);
        employeeService.addEmployee(employee);
        return ResponseEntity.ok("Employee added successfully");


    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees()
    {
       return employeeService.getAllEmployees();

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee)
    {
        String resp= employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(resp);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id)
    {
        String resp = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(resp);

    }

}

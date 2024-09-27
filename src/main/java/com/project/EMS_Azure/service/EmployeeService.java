package com.project.EMS_Azure.service;

import com.project.EMS_Azure.model.Employee;
import com.project.EMS_Azure.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService
{

    private final EmployeeRepo employeeRepo;

    public void addEmployee(Employee employee)
    {
        System.out.println("Started service" + employee);
        employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = employeeRepo.findAll();
        return employees;

    }

    public String updateEmployee(Integer id, Employee employee)
    {
        Employee existingEmployee = employeeRepo.findById(id).orElse(null);
        if(existingEmployee != null)
        {
            existingEmployee.setId(id);
            existingEmployee.setName(employee.getName());
            existingEmployee.setDept(employee.getDept());
            existingEmployee.setSalary(employee.getSalary());

            employeeRepo.save(existingEmployee);
        }
        return "Employee Update Successfully";
    }

    public String deleteEmployee(Integer id)
    {
        Employee existingEmployee = employeeRepo.findById(id).orElse(null);
        if(existingEmployee != null)
        {
            employeeRepo.delete(existingEmployee);
            return "Employee Deleted Successfully";
        }
        return "Employee Not Found";
    }
}

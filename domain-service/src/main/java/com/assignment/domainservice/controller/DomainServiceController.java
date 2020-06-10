package com.assignment.domainservice.controller;

import com.assignment.domainservice.model.Employee;
import com.assignment.domainservice.model.EmployeeFullDetails;
import com.assignment.domainservice.model.EmployeeList;
import com.assignment.domainservice.service.EmployeeCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DomainServiceController {
    @Autowired
    private EmployeeCrudService employeeCrudService;

    @PostMapping("/domain/addEmployee")
    public EmployeeFullDetails addEmploye(@RequestBody EmployeeFullDetails employee) {
        return employeeCrudService.addEmployee(employee);
    }

    @GetMapping("/domain/allEmployees")
    public EmployeeList getAllEmployees() {
        EmployeeList employeeList = new EmployeeList();
        List<EmployeeFullDetails> employeeFullDetailsList = employeeCrudService.getAllEmployeesStored();
        employeeList.setEmployeeFullDetailsList(employeeFullDetailsList);
        return employeeList;
    }

    @PutMapping("/domain/updateEmployee")
    public EmployeeFullDetails updateEmployee(@RequestBody EmployeeFullDetails employeeFullDetails) {
        return employeeCrudService.updateEmployee(employeeFullDetails);
    }

    @GetMapping("/domain/employee/{empId}")
    public EmployeeFullDetails getEmployeeById(@PathVariable String empId) {
        return employeeCrudService.getEmployeeByEmpId(empId);
    }
}

package com.assignment.presentationservice.controller;

import com.assignment.presentationservice.mapper.EmployeeAdditionalDetailsMapper;
import com.assignment.presentationservice.model.Employee;
import com.assignment.presentationservice.model.EmployeeFullDetails;
import com.assignment.presentationservice.model.EmployeeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PresentationServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmployeeAdditionalDetailsMapper employeeAdditionalDetailsMapper;

    @PostMapping("/addEmployee")
    public EmployeeFullDetails addEmployees(@RequestBody Employee employee) {
        String postUri = "http://domain-service/domain/addEmployee";
        EmployeeFullDetails employeeFullDetails = employeeAdditionalDetailsMapper.mapAdditionalDetails(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<EmployeeFullDetails> request = new HttpEntity<>(employeeFullDetails, headers);
        ResponseEntity<EmployeeFullDetails> response = restTemplate.exchange(postUri, HttpMethod.POST, request, EmployeeFullDetails.class);
        return response.getBody();
    }

    @GetMapping("/allEmployees")
    public List<EmployeeFullDetails> getAllEmployees() {
        String postUri = "http://domain-service/domain/allEmployees";
        EmployeeList employeeList = restTemplate.getForObject(postUri, EmployeeList.class);
        return employeeList.getEmployeeFullDetailsList();
    }

    @PutMapping("/updateEmployee")
    public EmployeeFullDetails updateEmployee(@RequestBody EmployeeFullDetails employeeFullDetails) {
        String uri = "http://domain-service/domain/updateEmployee";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<EmployeeFullDetails> request = new HttpEntity<>(employeeFullDetails, headers);
        ResponseEntity<EmployeeFullDetails> response = restTemplate.exchange(uri, HttpMethod.PUT, request, EmployeeFullDetails.class);
        return response.getBody();
    }

    @GetMapping("/employee/{empId}")
    public EmployeeFullDetails getEmployeeById(@PathVariable String empId) {
        String postUri = "http://domain-service/domain/employee/{empId}";
        return restTemplate.getForObject(postUri, EmployeeFullDetails.class, empId);
    }
}

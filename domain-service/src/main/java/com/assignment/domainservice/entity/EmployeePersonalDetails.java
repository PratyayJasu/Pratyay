package com.assignment.domainservice.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;

@Component
@Entity
public class EmployeePersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer empId;

    private String name;
    private String mail;
    private String address;
    private String phoneNumber;
    private LocalDate dateOfJoining;
    private String techStack;

    @OneToOne(mappedBy = "employeePersonalDetails")
    private EmployeeProjectDetails employeeProjectDetails;

    public EmployeeProjectDetails getEmployeeProjectDetails() {
        return employeeProjectDetails;
    }

    public EmployeePersonalDetails() {
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public String getTechStack() {
        return techStack;
    }

    public EmployeePersonalDetails setEmpId(Integer empId) {
        this.empId = empId;
        return this;
    }

    public EmployeePersonalDetails setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeePersonalDetails setMail(String name) {
        this.mail = name + "@citi.com";
        return this;
    }

    public EmployeePersonalDetails setAddress(String address) {
        this.address = address;
        return this;
    }

    public EmployeePersonalDetails setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public EmployeePersonalDetails setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
        return this;
    }

    public EmployeePersonalDetails setTechStack(String techStack) {
        this.techStack = techStack;
        return this;
    }

    public EmployeePersonalDetails setEmployeeProjectDetails(EmployeeProjectDetails employeeProjectDetails) {
        this.employeeProjectDetails = employeeProjectDetails;
        return this;
    }
}

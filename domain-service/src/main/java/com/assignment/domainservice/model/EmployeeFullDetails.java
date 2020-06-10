package com.assignment.domainservice.model;


import java.time.LocalDate;

public class EmployeeFullDetails {
    private Integer empId;
    private String name;
    private String address;
    private String phoneNumber;
    private LocalDate dateOfJoining;
    private String techStack;
    private String email;
    private String role;
    private String projectName;

    public EmployeeFullDetails() {
    }

    public EmployeeFullDetails(Integer empId, String name, String address, String phoneNumber, LocalDate dateOfJoining, String techStack, String email, String role, String projectName) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfJoining = dateOfJoining;
        this.techStack = techStack;
        this.email = email;
        this.role = role;
        this.projectName = projectName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
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

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getProjectName() {
        return projectName;
    }

    public EmployeeFullDetails setEmpId(Integer empId) {
        this.empId = empId;
        return this;
    }

    public EmployeeFullDetails setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeFullDetails setAddress(String address) {
        this.address = address;
        return this;
    }

    public EmployeeFullDetails setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public EmployeeFullDetails setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
        return this;
    }

    public EmployeeFullDetails setTechStack(String techStack) {
        this.techStack = techStack;
        return this;
    }

    public EmployeeFullDetails setEmail(String email) {
        this.email = email;
        return this;
    }

    public EmployeeFullDetails setRole(String role) {
        this.role = role;
        return this;
    }

    public EmployeeFullDetails setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    @Override
    public String toString() {
        return "EmployeeFullDetails{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", techStack='" + techStack + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}


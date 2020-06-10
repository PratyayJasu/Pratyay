package com.assignment.presentationservice.model;

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

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

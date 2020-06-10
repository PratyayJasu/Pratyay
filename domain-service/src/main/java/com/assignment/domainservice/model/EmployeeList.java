package com.assignment.domainservice.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private List<EmployeeFullDetails> employeeFullDetailsList;

    public EmployeeList() {
        employeeFullDetailsList = new ArrayList<>();
    }

    public List<EmployeeFullDetails> getEmployeeFullDetailsList() {
        return employeeFullDetailsList;
    }

    public void setEmployeeFullDetailsList(List<EmployeeFullDetails> employeeFullDetailsList) {
        this.employeeFullDetailsList = employeeFullDetailsList;
    }

    @Override
    public String toString() {
        return "EmployeeList{" +
                "employeeFullDetailsList=" + employeeFullDetailsList +
                '}';
    }
}

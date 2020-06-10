package com.assignment.presentationservice.mapper;

import com.assignment.presentationservice.model.Employee;
import com.assignment.presentationservice.model.EmployeeFullDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class EmployeeAdditionalDetailsMapper {
    public EmployeeFullDetails mapAdditionalDetails(Employee employee) {
        EmployeeFullDetails employeeFullDetails = new EmployeeFullDetails();
        employeeFullDetails.setName(employee.getName());
        employeeFullDetails.setAddress(employee.getAddress());
        employeeFullDetails.setDateOfJoining(employee.getDateOfJoining());
        employeeFullDetails.setPhoneNumber(employee.getPhoneNumber());
        employeeFullDetails.setTechStack(employee.getTechStack());
        employeeFullDetails.setRole(roleAssigner(employee.getDateOfJoining()));
        employeeFullDetails.setProjectName(projectAssigner(employee.getTechStack(), employee.getDateOfJoining()));
        return employeeFullDetails;
    }

    public String roleAssigner(LocalDate doj) {
        LocalDate now = LocalDate.now();
        int experience = Period.between(doj, now).getYears();
        return experience >=10 ? "TDL" : (experience > 5 && experience < 10)? "Senior Developer" : (experience > 2 && experience <= 5) ?
                "Developer" : "Trainee";
    }

    public String projectAssigner(String techStack, LocalDate doj) {
        LocalDate now = LocalDate.now();
        int experience = Period.between(doj, now).getYears();
        return (techStack.equalsIgnoreCase("Java") && experience >=5)  ? "Borrow Team 1" : (techStack.equalsIgnoreCase("Java") && experience < 5)
                ? "Borrow Team 2" : (techStack.equalsIgnoreCase("Angular") && experience >=5) ? "Borrow Team 2" : "Borrow Team 1";
    }
}

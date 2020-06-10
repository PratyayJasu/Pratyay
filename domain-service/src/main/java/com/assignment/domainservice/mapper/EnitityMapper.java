package com.assignment.domainservice.mapper;

import com.assignment.domainservice.entity.EmployeePersonalDetails;
import com.assignment.domainservice.entity.EmployeeProjectDetails;
import com.assignment.domainservice.model.EmployeeFullDetails;
import com.assignment.domainservice.repository.EmployeeDataRepository;
import com.assignment.domainservice.repository.EmployeeProjectDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnitityMapper {
    @Autowired
    private EmployeePersonalDetails employeePersonalDetails;
    @Autowired
    private EmployeeProjectDetails employeeProjectDetails;
    @Autowired
    private EmployeeProjectDataRepository employeeProjectDataRepository;
    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    public EmployeeProjectDetails getMappedEmployeeProjectDetails(EmployeeFullDetails employeeFullDetails) {
        LocalDate now = LocalDate.now();
        int experience = Period.between(employeeFullDetails.getDateOfJoining(), now).getYears();

        employeePersonalDetails.setName(employeeFullDetails.getName())
                .setAddress(employeeFullDetails.getAddress())
                .setDateOfJoining(employeeFullDetails.getDateOfJoining())
                .setPhoneNumber(employeeFullDetails.getPhoneNumber())
                .setTechStack(employeeFullDetails.getTechStack())
                .setMail(mailCreator(employeeFullDetails.getName(), getAllEmails()));

        employeeProjectDetails.setExperience(experience)
                .setProject(employeeFullDetails.getProjectName())
                .setRole(employeeFullDetails.getRole())
                .setEmployeePersonalDetails(employeePersonalDetails);
        return employeeProjectDetails;
    }

    private List<String> getAllEmails() {
        return employeeDataRepository.findAll().stream().map(employeePersonalDetails -> employeePersonalDetails.getMail().split("@")[0]).collect(Collectors.toList());
    }

    private String mailCreator(String name, List<String> allExistingMails) {
        String mail;
        mail = name.replace(" ", ".");
        if (allExistingMails.contains(mail)) {
            int incrementor = 1;
            while (incrementor < Integer.MAX_VALUE) {
                mail = mail + incrementor;
                if (!allExistingMails.contains(mail))
                    break;
                incrementor++;
            }
        }
        return mail;
    }
}

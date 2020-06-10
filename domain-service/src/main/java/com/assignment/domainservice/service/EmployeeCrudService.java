package com.assignment.domainservice.service;

import com.assignment.domainservice.entity.EmployeePersonalDetails;
import com.assignment.domainservice.entity.EmployeeProjectDetails;
import com.assignment.domainservice.mapper.EnitityMapper;
import com.assignment.domainservice.model.EmployeeFullDetails;
import com.assignment.domainservice.repository.EmployeeDataRepository;
import com.assignment.domainservice.repository.EmployeeProjectDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeCrudService {

    @Autowired
    private EmployeeProjectDataRepository employeeProjectDataRepository;
    @Autowired
    private EmployeeDataRepository employeeDataRepository;
    @Autowired
    private EnitityMapper enitityMapper;

    public EmployeeFullDetails addEmployee(EmployeeFullDetails employeeFullDetails) {
        EmployeeProjectDetails employeeProjectDetails = enitityMapper.getMappedEmployeeProjectDetails(employeeFullDetails);
        employeeProjectDetails = employeeProjectDataRepository.save(employeeProjectDetails);
        employeeFullDetails.setEmail(employeeProjectDetails.getEmployeePersonalDetails().getMail());
        employeeFullDetails.setEmpId(employeeProjectDetails.getEmployeePersonalDetails().getEmpId());
        return employeeFullDetails;
    }

    public List<EmployeeFullDetails> getAllEmployeesStored() {
        return employeeProjectDataRepository.findAll().stream()
                .map(p -> new EmployeeFullDetails(p.getEmployeePersonalDetails().getEmpId(), p.getEmployeePersonalDetails().getName(), p.getEmployeePersonalDetails().getAddress(), p.getEmployeePersonalDetails().getPhoneNumber(),
                        p.getEmployeePersonalDetails().getDateOfJoining(),
                        p.getEmployeePersonalDetails().getTechStack(), p.getEmployeePersonalDetails().getMail(), p.getRole(), p.getProject()))
                .collect(Collectors.toList());
    }

    public EmployeeFullDetails updateEmployee(EmployeeFullDetails employeeFullDetails) {
        EmployeeProjectDetails employeeProjectDetails = enitityMapper.getMappedEmployeeProjectDetails(employeeFullDetails);
        employeeProjectDataRepository.save(employeeProjectDetails);
        return employeeFullDetails;
    }

    public EmployeeFullDetails getEmployeeByEmpId(String empId) {
        EmployeePersonalDetails employeePersonalDetails = employeeDataRepository.findByEmpId(Integer.parseInt(empId));
        return new EmployeeFullDetails(employeePersonalDetails.getEmpId(), employeePersonalDetails.getName(),
                employeePersonalDetails.getAddress(), employeePersonalDetails.getPhoneNumber(), employeePersonalDetails.getDateOfJoining()
        , employeePersonalDetails.getTechStack(), employeePersonalDetails.getMail(), employeePersonalDetails.getEmployeeProjectDetails().getRole()
        , employeePersonalDetails.getEmployeeProjectDetails().getProject());
    }

}

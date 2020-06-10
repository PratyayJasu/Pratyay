package com.assignment.domainservice.repository;

import com.assignment.domainservice.entity.EmployeePersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeDataRepository extends JpaRepository<EmployeePersonalDetails, Integer> {
    public EmployeePersonalDetails findByEmpId(Integer empId);
}

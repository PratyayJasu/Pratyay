package com.assignment.domainservice.repository;

import com.assignment.domainservice.entity.EmployeeProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProjectDataRepository extends JpaRepository<EmployeeProjectDetails, Integer> {

}

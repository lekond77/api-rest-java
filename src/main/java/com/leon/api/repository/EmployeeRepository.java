package com.leon.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.api.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}

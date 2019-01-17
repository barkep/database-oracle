package com.kepka.databaseoracle.repository;

import com.kepka.databaseoracle.model.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends CrudRepository<Employees, Long> {

    List<Employees> findByEmployeeId(long employeeId);
    List<Employees> getAllByEmployeeIdIsNotNull();


}

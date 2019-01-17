package com.kepka.databaseoracle.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeesService {
    List<String> getEmployeeById(long employeeId);
    List<String> getAllEmployee();
    void addEmployee (String firstName, String lastName, String email, String phoneNumber);
}

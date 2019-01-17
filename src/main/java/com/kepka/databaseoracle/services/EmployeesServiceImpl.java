package com.kepka.databaseoracle.services;

import com.kepka.databaseoracle.model.Employees;
import com.kepka.databaseoracle.repository.EmployeesRepository;
import oracle.sql.DATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeesServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public List<String> getEmployeeById(long employeeId) {
        List<String> result = new ArrayList<>();
        List<Employees> employees = employeesRepository.findByEmployeeId(employeeId);
        for (Employees employee : employees) {
            result.add(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getPhoneNumber());
        }
        return result;
    }

    @Override
    public List<String> getAllEmployee() {
        List<String> result = new ArrayList<>();
        List<Employees> employees = employeesRepository.getAllByEmployeeIdIsNotNull();
        for (Employees employee : employees) {
            result.add(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getPhoneNumber());
        }
        return result;
    }

    @Override
    public void addEmployee(String firstName, String lastName, String email, String phoneNumber) {
        Employees newEmployee = new Employees();
        newEmployee.setFirstName(firstName);
        newEmployee.setLastName(lastName);
        newEmployee.setEmail(email);
        newEmployee.setPhoneNumber(phoneNumber);
        newEmployee.setHireDate(new Time(12,12,12));
        employeesRepository.save(newEmployee);
    }
}

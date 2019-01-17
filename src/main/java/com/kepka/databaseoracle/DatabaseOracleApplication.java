package com.kepka.databaseoracle;

import com.kepka.databaseoracle.services.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DatabaseOracleApplication implements CommandLineRunner {

    @Autowired
    EmployeesServiceImpl employeesService;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseOracleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        List<String> employees = employeesService.getEmployeeById(100);
        for (String employee : employees) {
            System.out.println("Pracownik: " + employee);
        }


        employees = employeesService.getAllEmployee();
        for (String employee : employees) {
            System.out.println("Pracownik: " + employee);
        }

        employeesService.addEmployee("Ziomek","taki", "asdsad", "656+55654654");

        employees = employeesService.getAllEmployee();
        for (String employee : employees) {
            System.out.println("Pracownik: " + employee);
        }

    }
}


package com.kepka.databaseoracle.services.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    void addStudent(String imie, String nazwisko, String telefon);

    List<String> getAllStudent();
}

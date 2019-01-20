package com.kepka.databaseoracle.services.student;

import com.kepka.databaseoracle.model.Student;
import com.kepka.databaseoracle.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(String imie, String nazwisko, String telefon) {
        Student student = new Student();
//        student.setId(id);
        student.setImie(imie);
        student.setNazwisko(nazwisko);
        student.setTelefon(telefon);
        studentRepository.save(student);
    }

    @Override
    public List<String> getAllStudent() {
        List<String> result = new ArrayList<>();
        List<Student> students = studentRepository.getAllByIdIsNotNull();
        for (Student student : students) {
            result.add(student.getId() + " " + student.getImie() + " " + student.getNazwisko() + " " + student.getTelefon());
        }
        return result;
    }
}


package com.kepka.databaseoracle.repository;

import com.kepka.databaseoracle.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> getAllByIdIsNotNull();

    List<Student> getById(long id);

    List<Student> getByImie(String imie);

    List<Student> getByNazwisko(String nazwisko);

    List<Student> getByTelefon(String telefon);
}

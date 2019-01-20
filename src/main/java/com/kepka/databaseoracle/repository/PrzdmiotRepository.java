package com.kepka.databaseoracle.repository;

import com.kepka.databaseoracle.model.Przedmiot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrzdmiotRepository extends CrudRepository<Przedmiot, Long> {

    List<Przedmiot> getAllByIdIsNotNull();

    List<Przedmiot> getById(long id);

    List<Przedmiot> getByNazwa(String nazwa);

    List<Przedmiot> getByProwadzacy(String prowadzacy);

}

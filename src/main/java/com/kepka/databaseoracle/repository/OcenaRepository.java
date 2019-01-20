package com.kepka.databaseoracle.repository;

import com.kepka.databaseoracle.model.Ocena;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OcenaRepository extends CrudRepository<Ocena, Long> {

    List<Ocena> getById(long id);
    List<Ocena> getAllByIdIsNotNull();
}

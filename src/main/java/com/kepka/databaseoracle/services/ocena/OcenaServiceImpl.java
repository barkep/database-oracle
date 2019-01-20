package com.kepka.databaseoracle.services.ocena;

import com.kepka.databaseoracle.model.Ocena;
import com.kepka.databaseoracle.repository.OcenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcenaServiceImpl implements OcenaService {

    private final OcenaRepository ocenaRepository;

    @Autowired
    public OcenaServiceImpl(OcenaRepository ocenaRepository) {
        this.ocenaRepository = ocenaRepository;
    }

    @Override
    public void addOcena(long id, long ocena1) {
        Ocena ocena = new Ocena();
        ocena.setId(id);
        ocena.setOcena(ocena1);
        ocenaRepository.save(ocena);
    }
}

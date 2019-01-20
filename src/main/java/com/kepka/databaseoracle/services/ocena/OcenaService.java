package com.kepka.databaseoracle.services.ocena;

import org.springframework.stereotype.Service;

@Service
public interface OcenaService {
    void addOcena (long id, long ocena);
}

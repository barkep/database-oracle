package com.kepka.databaseoracle.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Przedmiot {
    private long id;
    private String nazwa;
    private String prowadzacy;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRZEDMIOT_SEQ")
    @SequenceGenerator(sequenceName = "PRZEDMIOT_SEQ", allocationSize = 1, name = "PRZED_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAZWA")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "PROWADZACY")
    public String getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(String prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Przedmiot przedmiot = (Przedmiot) o;

        if (id != przedmiot.id) return false;
        if (!Objects.equals(nazwa, przedmiot.nazwa)) return false;
        return Objects.equals(prowadzacy, przedmiot.prowadzacy);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (prowadzacy != null ? prowadzacy.hashCode() : 0);
        return result;
    }
}

package com.kepka.databaseoracle.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {
    private long id;
    private String imie;
    private String nazwisko;
    private String telefon;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(sequenceName = "STUDENT_SEQ", name = "STUDENT_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IMIE")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "NAZWISKO")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    @Column(name = "TELEFON")
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (!Objects.equals(imie, student.imie)) return false;
        if (!Objects.equals(nazwisko, student.nazwisko)) return false;
        return Objects.equals(telefon, student.telefon);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);
        return result;
    }
}

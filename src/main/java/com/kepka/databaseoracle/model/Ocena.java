package com.kepka.databaseoracle.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ocena {
    private long id;
    private Long ocena;
    private Student studentByStudentId;
    private Przedmiot przedmiotByPrzedmiotId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OCENA_SEQ")
    @SequenceGenerator(sequenceName = "OCENA_SEQ", allocationSize = 1, name = "OCEN_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "OCENA")
    public Long getOcena() {
        return ocena;
    }

    public void setOcena(Long ocena) {
        this.ocena = ocena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ocena ocena1 = (Ocena) o;

        if (id != ocena1.id) return false;
        return Objects.equals(ocena, ocena1.ocena);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (ocena != null ? ocena.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID", nullable = false)
    public Student getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(Student studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "PRZEDMIOT_ID", referencedColumnName = "ID", nullable = false)
    public Przedmiot getPrzedmiotByPrzedmiotId() {
        return przedmiotByPrzedmiotId;
    }

    public void setPrzedmiotByPrzedmiotId(Przedmiot przedmiotByPrzedmiotId) {
        this.przedmiotByPrzedmiotId = przedmiotByPrzedmiotId;
    }
}

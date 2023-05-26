package com.example.inf204backendklinik.doktor;
import com.example.inf204backendklinik.termine.Termine;
import jakarta.persistence.*;

@Entity
@Table(name = "Doktor")
public class Doktor {

    @Id
    @SequenceGenerator(
            name = "doktor_sequence",
            sequenceName = "doktor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doktor_sequence"
    )
    @Column(name="doktor_id")
    private Long doktor_id;
    @Column(name="doktor_name")
    private String doktor_name;
    @Column(name="doktor_nachname")
    private String doktor_nachname;
    @Column(name="abteilung")
    private String abteilung;
    public Doktor() {
    }

    public Doktor(Long doktor_id) {
        this.doktor_id = doktor_id;
    }

    public Doktor(Long doktor_id, String doktor_name, String doktor_nachname, String abteilung) {
        this.doktor_id = doktor_id;
        this.doktor_name = doktor_name;
        this.doktor_nachname = doktor_nachname;
        this.abteilung = abteilung;
    }

    public Doktor(String doktor_name, String doktor_nachname, String abteilung) {
        this.doktor_name = doktor_name;
        this.doktor_nachname = doktor_nachname;
        this.abteilung = abteilung;
    }

    public Long getDoktor_id() {
        return doktor_id;
    }

    public void setDoktor_id(Long doktor_id) {
        this.doktor_id = doktor_id;
    }

    public String getDoktor_name() {
        return doktor_name;
    }

    public void setDoktor_name(String doktor_name) {
        this.doktor_name = doktor_name;
    }

    public String getDoktor_nachname() {
        return doktor_nachname;
    }

    public void setDoktor_nachname(String doktor_nachname) {
        this.doktor_nachname = doktor_nachname;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    @Override
    public String toString() {
        return "Doktor{" +
                "doktor_id=" + doktor_id +
                ", doktor_name='" + doktor_name + '\'' +
                ", doktor_nachname='" + doktor_nachname + '\'' +
                ", abteilung='" + abteilung + '\'' +
                '}';
    }
}

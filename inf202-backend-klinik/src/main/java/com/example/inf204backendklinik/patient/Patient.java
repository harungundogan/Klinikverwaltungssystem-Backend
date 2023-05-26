package com.example.inf204backendklinik.patient;


import com.example.inf204backendklinik.termine.Termine;
import jakarta.persistence.*;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    private Long ausweisnummer;
    @Column(name="name")
    private String name;
    @Column(name="nachname")
    private String nachname;
    @Column(name="phonenummer")
    private String phonenummer;

    public Patient() {
    }

    public Patient(Long ausweisnummer) {
        this.ausweisnummer=ausweisnummer;
    }

    public Patient(Long ausweisnummer, String name, String nachname,  String phonenummer) {
        this.name = name;
        this.nachname = nachname;
        this.ausweisnummer = ausweisnummer;
        this.phonenummer = phonenummer;
    }

    public Patient(String name, String nachname, String phonenummer) {
        this.name = name;
        this.nachname = nachname;
        this.phonenummer = phonenummer;
    }


    public Long getAusweisnummer() {
        return ausweisnummer;
    }

    public void setAusweisnummer(Long ausweisnummer) {
        this.ausweisnummer = ausweisnummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getPhonenummer() {
        return phonenummer;
    }

    public void setPhonenummer(String phonenummer) {
        this.phonenummer = phonenummer;
    }
}


package com.example.inf204backendklinik.termine;
import com.example.inf204backendklinik.doktor.Doktor;
import com.example.inf204backendklinik.patient.Patient;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Termine")
public class Termine {
    @Id
    @SequenceGenerator(
            name = "termine_sequence",
            sequenceName = "termine_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "termine_sequence"
    )
    private Long termin_id;
    @Column(name="terminDatum")
    private LocalDateTime terminDatum;
    @Column(name="zeit")
    private String zeit;
    @OneToOne(cascade = CascadeType.MERGE)
    private Patient patient;
    @OneToOne(cascade = CascadeType.MERGE)
    private Doktor doktor;

    public Termine() {
    }

    public Termine(Long termin_id, LocalDateTime terminDatum, String zeit) {
        this.termin_id = termin_id;
        this.terminDatum = terminDatum;
        this.zeit = zeit;

    }

    public Termine(LocalDateTime terminDatum, String zeit) {
        this.terminDatum = terminDatum;
        this.zeit = zeit;
    }

    public Long getTermin_id() {
        return termin_id;
    }

    public void setTermin_id(Long termin_id) {
        this.termin_id = termin_id;
    }

    public LocalDateTime getTerminDatum() {
        return terminDatum;
    }

    public void setTerminDatum(LocalDateTime terminDatum) {
        this.terminDatum = terminDatum;
    }

    public String getZeit() {
        return zeit;
    }

    public void setZeit(String zeit) {
        this.zeit = zeit;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }
}

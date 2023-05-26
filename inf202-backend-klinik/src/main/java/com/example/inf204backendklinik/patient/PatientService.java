package com.example.inf204backendklinik.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public void addNewPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public void deletePatient(Long patientId){
        patientRepository.deleteById(patientId);
    }
}

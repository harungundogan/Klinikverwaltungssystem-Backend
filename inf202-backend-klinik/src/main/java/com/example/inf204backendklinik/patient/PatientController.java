package com.example.inf204backendklinik.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/Patiente")

public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path="/allePatiente")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }
    @PostMapping(path="/neuerPatient")
    public void registerNewPatient(@RequestBody Patient patient){
        patientService.addNewPatient(patient);
    }

}

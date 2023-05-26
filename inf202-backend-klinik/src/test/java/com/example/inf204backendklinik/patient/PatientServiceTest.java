package com.example.inf204backendklinik.patient;


import com.example.inf204backendklinik.doktor.Doktor;
import com.example.inf204backendklinik.termine.Termine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;
    private PatientService underTest;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new PatientService(patientRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }
    @Test
    void canGetPatiente() {
        //when
        underTest.getPatients();
        //then
        Mockito.verify(patientRepository).findAll();
    }


    @Test
    void addNewPatient() {

            //given
        Patient patient = new Patient(
                39276566666L,
                "Zeynep",
                "Nur",
                "05634525263"

        );
            // when
            underTest.addNewPatient(patient);
            //then
            ArgumentCaptor<Patient> patientArgumentCaptor = ArgumentCaptor.forClass(Patient.class);
            Mockito.verify(patientRepository).save(patientArgumentCaptor.capture());
            Patient capturedPatient = patientArgumentCaptor.getValue();
            assertThat(capturedPatient).isEqualTo(patient);

    }


}
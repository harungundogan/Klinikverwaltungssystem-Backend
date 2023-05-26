package com.example.inf204backendklinik.patient;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PatientConfig {
    @Bean
    CommandLineRunner commandLineRunnerPatient(PatientRepository repository){
        return args -> {
            Patient merve = new Patient(
                    39271172908L,
                    "Merve",
                    "Can",
                    "05417897890"

            );
            Patient zeynep = new Patient(
                    39276666666L,
                    "Zeynep",
                    "Nur",
                    "05634525263"

            );
            repository.saveAll(List.of(merve, zeynep));
        };

    }

}

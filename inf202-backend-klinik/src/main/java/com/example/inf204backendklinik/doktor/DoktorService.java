package com.example.inf204backendklinik.doktor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DoktorService {

    private final DoktorRepository doktorRepository;

    @Autowired
    public DoktorService(DoktorRepository doktorRepository) {
        this.doktorRepository = doktorRepository;
    }


    public List<Doktor> getDoktors() {
       return doktorRepository.findAll();
    }

    public void addNewDoktor(Doktor doktor) {
        doktorRepository.save(doktor);
    }

    public void deleteDoktor(Long doktorId) {
        boolean exists = doktorRepository.existsById(doktorId);
        if (!exists){
            throw new IllegalStateException("doktor ist nicht da");
        }
        doktorRepository.deleteById(doktorId);
    }
}

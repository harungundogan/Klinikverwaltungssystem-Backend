package com.example.inf204backendklinik.doktor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="doktors")

public class DoktorController {
    private final DoktorService doktorService;

    @Autowired
    public DoktorController(DoktorService doktorService) {
        this.doktorService = doktorService;
    }

    @GetMapping()

    public List<Doktor> getDoktors() {
        return doktorService.getDoktors();
    }
    @PostMapping
    public void registerNewDoktor(@RequestBody Doktor doktor){
        doktorService.addNewDoktor(doktor);
    }

}

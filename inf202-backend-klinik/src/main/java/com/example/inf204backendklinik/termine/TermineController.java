package com.example.inf204backendklinik.termine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/Termine")
public class TermineController {
    private final TermineService termineService;

    @Autowired
    public TermineController(TermineService termineService) {
        this.termineService = termineService;
    }

    @GetMapping(path="/alleTermine")
    public List<Termine> getTermine() {
        return termineService.getTermine();
    }

    @PostMapping(path="/neuerTermin")
    public void ertellNeuenTermin(@RequestBody Termine termin) {
        termineService.erstellNeuenTermin(termin);
    }

}

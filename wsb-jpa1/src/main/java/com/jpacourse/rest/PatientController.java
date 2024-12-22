package com.jpacourse.rest;

import com.jpacourse.dto.NewVisitTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient/{id}")
    PatientTO findBaId(@PathVariable final Long id) {
        final PatientTO patient = patientService.findById(id);
        if (patient == null) {
            throw new EntityNotFoundException(id);
        }

        return patient;
    }

    @PostMapping("/patient/visit")
    @ResponseStatus(HttpStatus.CREATED)
    PatientTO addNewVisit(@RequestBody NewVisitTO visit) {
        return patientService.createNewVisit(visit);
    }
}

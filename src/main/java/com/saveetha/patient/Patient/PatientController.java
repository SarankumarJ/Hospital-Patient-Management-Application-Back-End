package com.saveetha.patient.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {

        this.patientService = patientService;
    }

    @GetMapping("/")
    public List<Patient> getPatientDetails()
    {
        return patientService.displayPatientDetails();
    }
    @PostMapping("/")
    public void postPatient(@RequestBody Patient patient){

        patientService.registerNewPatient(patient);
    }
    @DeleteMapping(path = {"/{id}"})
    public void deletePatient(@PathVariable("id") Long patientId)
    {
        patientService.removePatient(patientId);
    }
}

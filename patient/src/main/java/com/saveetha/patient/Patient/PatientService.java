package com.saveetha.patient.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PatientService {

    private static PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public static List<Patient> displayPatientDetails() {
        return patientRepository.findAll();
    }

    public void registerNewPatient(Patient patient) {
        Optional<Patient> patientOptional = patientRepository.findPatientById(patient.getPatientId());

        if(patientOptional.isPresent()){
            throw new IllegalStateException("Id already used");
        }
        patientRepository.save(patient);
    }

    public void removePatient(Long patientId) {
        boolean patientExists = patientRepository.existsById(patientId);

        if(!patientExists)
        {
            throw new IllegalStateException("Patient with ID "+patientId+"doesn't exist");
        }
        patientRepository.deleteById(patientId);
    }
}

package com.saveetha.patient.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query("Select patient from Patient patient where patient.patientId = ?1")
    Optional<Patient> findPatientById(Long patientId);
}

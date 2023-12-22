package org.application.controller;

import org.application.entity.Patient;
import org.application.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody Patient patient) {
        try {
            Patient createdPatient = patientService.createPatient(patient);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create patient: " + e.getMessage());
        }
    }

    @GetMapping("/{patient_id}")
    public ResponseEntity<?> getPatientById(@PathVariable("patient_id") Long patient_id) {
        try {
            Patient patient = patientService.getPatientById(patient_id);
            return ResponseEntity.status(HttpStatus.OK).body(patient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
    }

    @PutMapping("/{patient_id}")
    public ResponseEntity<?> updatePatient(@PathVariable("patient_id") Long patient_id, @RequestBody Patient patient) {
        try {
            Patient updatedPatient = patientService.updatePatient(patient_id, patient);
            return ResponseEntity.status(HttpStatus.OK).body(updatedPatient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update patient: " + e.getMessage());
        }
    }

    @DeleteMapping("/{patient_id}")
    public ResponseEntity<?> deletePatient(@PathVariable("patient_id") Long patient_id) {
        try {
            patientService.deletePatient(patient_id);
            return ResponseEntity.status(HttpStatus.OK).body("Patient deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete patient: " + e.getMessage());
        }
    }

}

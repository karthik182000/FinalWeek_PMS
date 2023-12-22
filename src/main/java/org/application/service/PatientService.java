package org.application.service;

import org.application.entity.Patient;

public interface PatientService {
    Patient createPatient(Patient patient);

    Patient getPatientById(Long patient_id);

    Patient updatePatient(Long patient_id, Patient updatedPatient);

    void deletePatient(Long patient_id);

}

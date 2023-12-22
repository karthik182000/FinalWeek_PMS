package org.application.service.impl;

import org.application.entity.Patient;
import org.application.repository.PatientRepository;
import org.application.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient createPatient(Patient patient) {
        if (patient != null) {
            return patientRepository.save(patient);
        } else {
            throw new IllegalArgumentException("Invalid patient data provided");
        }
    }

    @Override
    public Patient getPatientById(Long patient_id) {
        return patientRepository.findById(patient_id)
                .orElseThrow(() -> new NoSuchElementException("Patient not found with ID: " + patient_id));
    }

    @Override
    public Patient updatePatient(Long patient_id, Patient updatedPatient) {
        // Implement logic to update a patient
        Patient existingPatient = getPatientById(patient_id);

        // Update the existing patient entity with new details

        existingPatient.setFirstName(updatedPatient.getFirstName());
        existingPatient.setLastName(updatedPatient.getLastName());
        existingPatient.setDateOfBirth(updatedPatient.getDateOfBirth());
        existingPatient.setGender(updatedPatient.getGender());
        existingPatient.setContactList(updatedPatient.getContactList());
        existingPatient.setAddressList(updatedPatient.getAddressList());
        existingPatient.setClinicalList(updatedPatient.getClinicalList());
        existingPatient.setPrescriber(updatedPatient.getPrescriber());
        existingPatient.setPrescriptionList(updatedPatient.getPrescriptionList());
        existingPatient.setInsuranceList(updatedPatient.getInsuranceList());
        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(Long patient_id) {
        Patient patient = getPatientById(patient_id);
        patientRepository.delete(patient);
    }

}

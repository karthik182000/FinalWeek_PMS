package org.application.service.impl;

import jakarta.transaction.Transactional;
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
    @Transactional
    public Patient updatePatient(Long patient_id, Patient updatedPatient) {
        Patient existingPatient = getPatientById(patient_id);

        // Update the existing patient entity with new details
        existingPatient.setFirstName(updatedPatient.getFirstName());
        existingPatient.setLastName(updatedPatient.getLastName());
        existingPatient.setDateOfBirth(updatedPatient.getDateOfBirth());
        existingPatient.setGender(updatedPatient.getGender());

        // Update Contact List
        if (updatedPatient.getContactList() != null) {
            existingPatient.getContactList().clear();
            existingPatient.getContactList().addAll(updatedPatient.getContactList());
            existingPatient.getContactList().forEach(contact -> contact.setPatient(existingPatient));
        }

        // Update Address List
        if (updatedPatient.getAddressList() != null) {
            existingPatient.getAddressList().clear();
            existingPatient.getAddressList().addAll(updatedPatient.getAddressList());
            existingPatient.getAddressList().forEach(address -> address.setPatient(existingPatient));
        }

        // Update Clinical List
        if (updatedPatient.getClinicalList() != null) {
            existingPatient.getClinicalList().clear();
            existingPatient.getClinicalList().addAll(updatedPatient.getClinicalList());
            existingPatient.getClinicalList().forEach(clinical -> {
                clinical.setPatient(existingPatient);
                if (clinical.getAllergies() != null) {
                    clinical.getAllergies().setClinical(clinical);
                }
            });
        }

        // Update Prescriber
        if (updatedPatient.getPrescriberList() != null) {
            existingPatient.getPrescriberList().clear();
            existingPatient.getPrescriberList().addAll(updatedPatient.getPrescriberList());
            existingPatient.getPrescriberList().forEach(prescriber-> prescriber.setPatient(existingPatient));
        }

        // Update Prescription List
        if (updatedPatient.getPrescriptionList() != null) {
            existingPatient.getPrescriptionList().clear();
            existingPatient.getPrescriptionList().addAll(updatedPatient.getPrescriptionList());
            existingPatient.getPrescriptionList().forEach(prescription -> prescription.setPatient(existingPatient));
        }

        // Update Insurance List
        if (updatedPatient.getInsuranceList() != null) {
            existingPatient.getInsuranceList().clear();
            existingPatient.getInsuranceList().addAll(updatedPatient.getInsuranceList());
            existingPatient.getInsuranceList().forEach(insurance -> insurance.setPatient(existingPatient));
        }

        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(Long patient_id) {
        Patient patient = getPatientById(patient_id);
        patientRepository.delete(patient);
    }

}

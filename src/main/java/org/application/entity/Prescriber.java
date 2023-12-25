package org.application.entity;

import jakarta.persistence.*;
import org.application.entity.Patient;

import java.util.*;

@Entity
@Table(name = "prescriber")
public class Prescriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriber_id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "npi_number")
    private Long npiNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Prescriber() {
    }

    // Constructors with required fields
    public Prescriber(Long npiNumber, String firstName, String lastName) {
        this.npiNumber = npiNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Long getPrescriber_id() {
        return prescriber_id;
    }

    public void setPrescriber_id(Long prescriber_id) {
        this.prescriber_id = prescriber_id;
    }
    public Long getNpiNumber() {
        return npiNumber;
    }

    public void setNpiNumber(Long npiNumber) {
        this.npiNumber = npiNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


}

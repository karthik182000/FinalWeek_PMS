package org.application.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clinical")
public class Clinical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clinical_id;


    @OneToOne(mappedBy = "clinical", cascade = CascadeType.ALL)
    private Allergies allergies;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Clinical() {

    }

    public Allergies getAllergies() {
        return allergies;
    }

    public void setAllergies(Allergies allergies) {
        this.allergies = allergies;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
